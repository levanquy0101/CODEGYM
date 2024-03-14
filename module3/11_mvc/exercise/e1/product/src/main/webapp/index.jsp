<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Bootstrap CRUD Data Table for Database with Modal Form</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="css/style.css">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    <script src="js/main.js"></script>
</head>
<body>
<div class="container-xl">
    <div class="table-responsive">
        <div class="table-wrapper">
            <div class="table-title">
                <div class="row">
                    <div class="col-md-3 col-sm-6">
                        <h2>Manage <b>Products</b></h2>
                    </div>

                    <div class="col-md-5">
                        <form action="?action=search" method="post">
                           <input name="search">
                            <button>Search</button>
                        </form>
<%--                        <form action="?action=search" method="post">--%>
<%--                            <div class="input-group">--%>
<%--                                <div class="input-group-btn search-panel">--%>
<%--                                    <button type="button" class="tmp btn btn-default dropdown-toggle"--%>
<%--                                            data-toggle="dropdown">--%>
<%--                                        <span id="search_concept" class="tmp">All</span> <span class="tmp caret"></span>--%>
<%--                                    </button>--%>
<%--                                    <ul class="dropdown-menu scrollable-dropdown" role="menu">--%>
<%--                                        <li><a href="#">Name</a></li>--%>
<%--                                        <li><a href="#">Price</a></li>--%>
<%--                                        <li><a href="#">Quantity</a></li>--%>
<%--                                        <li><a href="#">Color</a></li>--%>
<%--                                        <li><a href="#">Category</a></li>--%>
<%--                                    </ul>--%>
<%--                                </div>--%>
<%--                                <input type="hidden" name="by" value="all" id="search_param">--%>
<%--                                <input type="text" class="form-control" name="val" placeholder="Search" value="${paging.searchVal}">--%>
<%--                                <span class="input-group-btn">--%>
<%--	     <button type="submit" class="tmp btn btn-default" style="height: 34px">--%>
<%--	       <span class="glyphicon glyphicon-search"></span>--%>
<%--	     </button>--%>
<%--	 </span>--%>
<%--                            </div>--%>
<%--                        </form>--%>
                    </div>

                    <div class="col-md-4 col-sm-6">
                        <a href="#employeeModal" class="add btn btn-success" data-toggle="modal"><i
                                class="material-icons">&#xE147;</i> <span>Add New Product</span></a>
                        <a href="#deleteEmployeeModal" class="deleteAll btn btn-danger" data-toggle="modal"><i
                                class="material-icons">&#xE15C;</i> <span>Delete</span></a>
                    </div>
                </div>
            </div>

            <table class="table table-striped table-hover">
                <thead>
                <tr>
                    <th>
							<span class="custom-checkbox">
								<input type="checkbox" id="selectAll">
								<label for="selectAll"></label>
							</span>
                    </th>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Description</th>
                    <th>Manufacture</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${products}" var="p">
                    <tr>
                        <td>
							<span class="custom-checkbox">
								<input type="checkbox" id="checkbox1" name="options[]" value="1">
								<label for="checkbox1"></label>
							</span>
                        </td>
                        <td>${p.name}</td>
                        <td>${p.price}</td>
                        <td>${p.description}</td>
                        <td>${p.manufacture}</td>
                        <td>
                            <a href="#employeeModal" class="edit" data-toggle="modal" data-id="${p.id}"
                               data-name="${p.name}"
                               data-price="${p.price}"
                               data-description="${p.description}"
                               data-manufacture="${p.manufacture}"><i class="material-icons"
                                                                      data-toggle="tooltip"
                                                                      title="Edit">&#xE254;</i></a>
                            <a href="#deleteEmployeeModal" class="delete" data-toggle="modal" data-id="${p.id}"><i class="material-icons"
                                                                                                 data-toggle="tooltip"
                                                                                                 title="Delete">&#xE872;</i></a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
<%--            <div class="clearfix">--%>
<%--                <div class="hint-text">Showing <b>5</b> out of <b>25</b> entries</div>--%>
<%--                <ul class="pagination">--%>
<%--                    <li class="page-item disabled"><a href="#">Previous</a></li>--%>
<%--                    <li class="page-item"><a href="#" class="page-link">1</a></li>--%>
<%--                    <li class="page-item"><a href="#" class="page-link">2</a></li>--%>
<%--                    <li class="page-item active"><a href="#" class="page-link">3</a></li>--%>
<%--                    <li class="page-item"><a href="#" class="page-link">4</a></li>--%>
<%--                    <li class="page-item"><a href="#" class="page-link">5</a></li>--%>
<%--                    <li class="page-item"><a href="#" class="page-link">Next</a></li>--%>
<%--                </ul>--%>
<%--            </div>--%>
        </div>
    </div>
</div>
<!-- Edit Modal HTML -->
<div id="employeeModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <form action="?action=save" method="post">
                <div class="modal-header">
                    <h4 class="modal-title">Edit Product</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                </div>
                <div class="modal-body">
                    <input type="hidden" name="id">
                    <div class="form-group">
                        <label>Name</label>
                        <input type="text" class="form-control" name="name">
                    </div>
                    <div class="form-group">
                        <label>Price</label>
                        <input type="text" class="form-control" name="price">
                    </div>
                    <div class="form-group">
                        <label>Description</label>
                        <textarea class="form-control" name="des"></textarea>
                    </div>
                    <div class="form-group">
                        <label>Manufacture</label>
                        <input type="text" class="form-control" name="manufacture">
                    </div>
                </div>
                <div class="modal-footer">
                    <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                    <input type="submit" class="btn btn-info" value="Save">
                </div>
            </form>
        </div>
    </div>
</div>
<!-- Delete Modal HTML -->
<div id="deleteEmployeeModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <form action="?action=delete" method="post">
                <input type="hidden" name="id">
                <div class="modal-header">
                    <h4 class="modal-title">Delete Product</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                </div>
                <div class="modal-body">
                    <p>Are you sure you want to delete these Records?</p>
                    <p class="text-warning"><small>This action cannot be undone.</small></p>
                </div>
                <div class="modal-footer">
                    <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                    <input type="submit" class="btn btn-danger" value="Delete">
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>