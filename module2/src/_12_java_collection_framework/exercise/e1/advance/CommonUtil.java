package _12_java_collection_framework.exercise.e1.advance;

import org.json.JSONArray;
import org.json.JSONObject;

import javax.tools.*;
import java.io.*;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.*;

public class CommonUtil {
    public static Scanner getScanner() {
        return new Scanner(System.in);
    }
    public static List<RunTimeClass> listClass;

    public static List<RunTimeClass> jSonToClass(String path) throws IOException, ClassNotFoundException {
        List<RunTimeClass> result = new ArrayList<>();

        String lines = readFile(path);
        JSONObject obj = new JSONObject(lines);
        Iterator<String> iterator = obj.keys();
        while(iterator.hasNext()){
            RunTimeClass runTimeClass = new RunTimeClass();
            Map<String, String> mapFields = new LinkedHashMap<>();
            Map<String, String> mapSort = new LinkedHashMap<>();

            String entity = iterator.next();
            runTimeClass.setEntityName(entity);

            JSONObject ent = obj.getJSONObject(entity);
            Set<String> keys= ent.keySet();
            for (int i = 0; i < keys.size(); i++) {
                JSONArray arr = ent.names();
                String field = arr.get(i).toString();

                if(field.equals("search")){
                    String val = ent.getString(field);
                    runTimeClass.setSearchBy(val);
                }
                else if(field.equals("sort")){
                    JSONObject jsonSort = ent.getJSONObject("sort");
                    JSONArray sortArrays = jsonSort.names();

                    for (int j = 0; j < sortArrays.length(); j++) {
                        String f = sortArrays.get(j).toString();
                        String v = jsonSort.getString(f);
                        mapSort.put(f,v);
                    }
                }
                else if(field.equals("field")){
                    JSONObject jsonField = ent.getJSONObject("field");
                    Set<String> aaa= jsonField.keySet();
                    JSONArray fieldArrays = jsonField.names();

                    for (int j = fieldArrays.length() - 1; j >= 0; j--) {
                        String f = fieldArrays.get(j).toString();
                        String v = jsonField.getString(f);
                        mapFields.put(f,v);
                    }
                }
            }

            runTimeClass.setFields(mapFields);
            runTimeClass.setSort(mapSort);
            runTimeClass.setCls(generateDynamicClass(runTimeClass));
            result.add(runTimeClass);
        }

        listClass = result;

        return result;
    }

    public static Object createInstance(RunTimeClass runTimeClass, List<String> params) {
        try {
            Constructor<?> ctor = runTimeClass.getCls().getConstructors()[0];
            ctor.setAccessible(true);

            Object[] tmp = new Object[runTimeClass.getFields().size()];

            List listKeys = new ArrayList<>(runTimeClass.getFields().values());
            for (int i = 0; i < runTimeClass.getFields().size(); i++) {
                String aaa= listKeys.get(i).toString();
                switch (listKeys.get(i).toString()) {
                    case "int":
                        tmp[i] = Integer.valueOf(params.get(i));
                        break;
                    case "double":
                        tmp[i] = Double.valueOf(params.get(i));
                        break;
                    default:
                        tmp[i] = params.get(i);
                }
            }

            return ctor.newInstance(tmp);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<String> inputFields(RunTimeClass runTimeClass){
        List result = new ArrayList();

        runTimeClass.getFields().keySet().forEach(e -> {
            String value = inputWithoutEmpty(e);
            result.add(value);
        });

        return result;
    }


    //region private method support build dynamic class
    private static Class<?> generateDynamicClass(RunTimeClass runTimeClass) throws IOException, ClassNotFoundException {
        File sourceFile = File.createTempFile(runTimeClass.getEntityName(), ".java");
        sourceFile.deleteOnExit();

        String classname = sourceFile.getName().split("\\.")[0];

        StringBuilder declareField = new StringBuilder();
        for (Map.Entry<String,String> entry : runTimeClass.getFields().entrySet()){
            declareField.append(generateField(entry.getKey(), entry.getValue()));
        }

        String sourceCode = "public class " + classname + String.format("{\n %s %s %s}", declareField, generateConstructor(classname, runTimeClass.getFields()), generateToString(runTimeClass));

        FileWriter writer = new FileWriter(sourceFile);
        writer.write(sourceCode);
        writer.close();

        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
        File parentDirectory = sourceFile.getParentFile();
        fileManager.setLocation(StandardLocation.CLASS_OUTPUT, Arrays.asList(parentDirectory));
        Iterable<? extends JavaFileObject> compilationUnits = fileManager.getJavaFileObjectsFromFiles(Arrays.asList(sourceFile));
        compiler.getTask(null, fileManager, null, null, null, compilationUnits).call();
        fileManager.close();

        URLClassLoader classLoader = URLClassLoader.newInstance(new URL[] { parentDirectory.toURI().toURL() });

        return classLoader.loadClass(classname);
    }

    private static String generateField(String fieldName, String dataType){
        String tmp = "private DataType FieldName;\n" +
                "\n" +
                "    public DataType getFieldName() {\n" +
                "        return FieldName;\n" +
                "    }\n" +
                "\n" +
                "    public void setFieldName(DataType fieldName) {\n" +
                "        FieldName = fieldName;\n" +
                "    }\n";

        return tmp.replace("FieldName",fieldName).replace("DataType", dataType);
    }

    private static String generateConstructor(String className, Map<String, String> fields){
        String params = "";
        String body = "";
        for (Map.Entry<String,String> entry : fields.entrySet()){
            String key = entry.getKey();
            String val = entry.getValue();
            params += val + " " + key + ",";
            body += "this." + key + "=" + key+ ";";
        }

        params = params.substring(0, params.length() - 1);
        String res = String.format("public %s(%s){%s}\n", className, params, body);
        return res;
    }

    private static String generateToString(RunTimeClass runTimeClass){
        String head = "@Override\n public String toString() { return \""+ runTimeClass.getEntityName()+"{\" +\n";
        String body = "";
        for (Map.Entry<String,String> entry : runTimeClass.getFields().entrySet()){
            String key = entry.getKey();
            body += "\", "+key+"=\"" +  String.format(" + %s +\n", key);
        }
        String res = head + body.replaceFirst(", ","") +  "'}';}";

        return res;
    }
    //endregion

    public static String inputWithoutEmpty(String fieldName) {
        String value = "0";
        do {
            System.out.print(value.isEmpty() ? fieldName + " cannot be empty. Please input again: " : fieldName + ": ");
            value = getScanner().nextLine();
        } while (value.isEmpty());

        return value;
    }

    private static String readFile(String path) {
        String res = "";

        try{
            File file= new File(path);
            if(!file.exists()){
                file.createNewFile();
            }

            BufferedReader bufferedReader= new BufferedReader(new FileReader(path));
            String line;
            while ((line= bufferedReader.readLine())!= null){
                res += line;
            }
            bufferedReader.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }

        return res;
    }

//    private static List listFromJsonSorted(JSONObject json) {
//        if (json == null){
//            return null;
//        }
//
//        SortedMap map = new TreeMap();
//        Iterator i = json.keys();
//        while (i.hasNext()) {
//            try {
//                String key = i.next().toString();
//                JSONObject j = json.getJSONObject(key);
//                map.put(key, j);
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//        }
//
//        return new LinkedList(map.values());
//    }
}
