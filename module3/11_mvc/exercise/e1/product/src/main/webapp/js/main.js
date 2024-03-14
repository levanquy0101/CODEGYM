$(document).ready(function(){
    $('[data-toggle="tooltip"]').tooltip();

    // Select/Deselect checkboxes
    let checkbox = $('table tbody input[type="checkbox"]');
    $("#selectAll").click(function(){
        if(this.checked){
            checkbox.each(function(){
                this.checked = true;
            });
        } else{
            checkbox.each(function(){
                this.checked = false;
            });
        }
    });
    checkbox.click(function(){
        if(!this.checked){
            $("#selectAll").prop("checked", false);
        }
    });

    $(".edit").click(function () {
        $(".modal-title").text("Edit Product");
        $("input[name='id']").val($(this).data("id"));
        $("input[name='name']").val($(this).data("name"));
        $("input[name='price']").val($(this).data("price"));
        $("textarea[name='des']").val($(this).data("description"));
        $("input[name='manufacture']").val($(this).data("manufacture"));
    });

    $(".add").click(function () {
        $(".modal-title").text("Add Product");
        $("input[name='id'], input[name='name'], input[name='price'], textarea[name='des'], input[name='manufacture']").val("");
    });

    $(".delete").click(function () {
        $("input[name='id']").val($(this).data("id"));
    });

    $(".deleteAll").click(function () {
        let checkboxArr=[];
        // checkbox.each(function(index){
        //     if(checkbox[index].checked){
        //         checkboxArr.push($(this).val());
        //     }
        // });
        checkbox.each(function(){
            if(this.checked){
                checkboxArr.push(this.value);
            }
        });

        if(checkboxArr.length<=0){
            $(this).attr("href","#");
            alert("Please choose at least one to delete");
            // $.fn.toastr("info","Please choose at least one to delete");
            return;
        }
        // $(this).attr("href","#deleteModal");
        $("input[name='id']").val(checkboxArr);
        // document.getElementById("hfDel").value=checkboxArr;
    });
});