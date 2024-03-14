import java.io.IOException;
import java.util.Optional;
import java.util.regex.Pattern;

@javax.servlet.annotation.WebServlet(name = "CalculateServlet", urlPatterns = "/calculate")
public class CalculateServlet extends javax.servlet.http.HttpServlet {
    private final Pattern patternIsDouble = Pattern.compile("\\d+(\\.\\d+)?");

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        Double first= convertToDouble(request.getParameter("first"));
        String operator= request.getParameter("operator");
        Double second= Double.parseDouble(request.getParameter("second"));

        try {
            double res= calculate(first, operator, second);
            request.setAttribute("res", res);
            request.getRequestDispatcher("result.jsp").forward(request, response);
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    private Double calculate(Double first, String operator, Double second) throws Exception{
        double res= 0;
        switch (operator){
            case "Addition":
                res= first+ second;
                break;
            case "Subtraction":
                res= first- second;
                break;
            case "Multiplication":
                res= first* second;
                break;
            case "Division":
                if(second==0)
                    throw new Exception("Cannot division to zero");
                res= first/second;
                break;
        }

        return res;
    }

    private double convertToDouble(String val){
        return Optional.ofNullable(val).filter(f-> !f.isEmpty() && patternIsDouble.matcher(val).matches()).map(Double::valueOf).orElse(0.0);
    }
}
