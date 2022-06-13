<%@ page import="java.util.HashMap" %>
<%@ page import="com.example.foodmodel.entity.Food" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.foodmodel.entity.Category" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.foodmodel.entity.entityEnum.FoodStatus" %>
<%@ page import="com.example.foodmodel.util.FormatterHelper" %>
<!DOCTYPE html>
<html lang="en">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/admin/components/header.jsp" />
<script src="https://cdn.ckeditor.com/ckeditor5/34.1.0/classic/ckeditor.js"></script>



<body>
<%
     List<Category> categories = (List<Category>) request.getAttribute("categories");
     if(categories == null){
         categories = new ArrayList<>();
     }
%>
<%
    HashMap<String, String> errors = (HashMap<String, String>) request.getAttribute("errors");
    if(errors == null) {
        errors = new HashMap<>();
    }
    Food food = (Food) request.getAttribute("food");
    if(food == null) {
        food = new Food();
    }
%>

<div class="container-scroller">
    <jsp:include page="/admin/components/narbar.jsp"/>
    <div class="container-fluid page-body-wrapper">
       <jsp:include page="/admin/components/settings-panel.jsp" />
       <jsp:include page="/admin/components/sidebar.jsp"/>

        <div class="main-panel" action="/foods/create" method="post" >
            <div class="content-wrapper">
                <div class="row">
                    <div class="col-12 grid-margin stretch-card">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title">Products</h4>
                                <p class="card-description">
                                    Create
                                </p>
                                <form class="forms-sample" action="/admin/foods/create" method="post">
                                    <div class="form-group">
                                        <label >Choose Category</label>
                                        <select class="nav-link dropdown-bordered dropdown-toggle dropdown-toggle-split show" name="categoryId" >
                                        <%for (int i = 0; i < categories.size(); i++) {%>
                                            <option value="<%= categories.get(i).getId()%>"><%=categories.get(i).getName()%></option>
                                            <%}%>
                                        </select>

                                    </div>
                                    <div class="form-group">
                                        <label for="name">Name</label>
                                        <input type="text" class="form-control" id="name" name="name"  value="<%= food.getName() %>"  placeholder="Name">
                                        <%
                                            if(errors.containsKey("name"))   {
                                        %>
                                        <div class="invalid-feedback">
                                            <%= errors.get("name")%>
                                        </div>
                                        <% } %>

                                    </div>
                                    <div class="form-group">
                                        <label for="description">Description</label>
                                        <input type="text" class="form-control"  id="description" name="description" value="<%= food.getDescription() %>" placeholder="Description">

                                    </div>
                                    <div class="form-group">
                                        <label for="price">Price</label>
                                        <input  class="form-control" id="price" name="price" placeholder="Price"  value="<%= food.getPrice() %>">
                                        <%
                                            if(errors.containsKey("price"))   {
                                        %>
                                        <div class="invalid-feedback">
                                            <%= errors.get("price")%>
                                        </div>
                                        <% } %>

                                    </div>
                                    <div class="form-group">
                                        <label >Thumbnail</label>
                                        <div class="input-group col-xs-12">


                                            <button id="upload_widget" type="button" name="thumbnail" class="btn btn-primary me-2"  value="<%= food.getThumbnail() %>">Choose Imange</button>
                                            <%
                                                if(errors.containsKey("thumbnail"))   {
                                            %>
                                            <div class="invalid-feedback">
                                                <%= errors.get("thumbnail")%>
                                            </div>
                                            <% } %>
                                        </div>
                                        <div>
                                        <img class="img-size-64 img-rounded img-thumbnail" id="preview-image" src="<%= food.getThumbnail()%>">
                                        <input type="hidden" name="thumbnail" id="hidden-thumbnails" value="">
                                    </div>
                                    </div>
                                    <div class="form-group">
                                        <label >Choose Status</label>
                                        <select class="nav-link dropdown-bordered dropdown-toggle dropdown-toggle-split show" name="status" >
                                            <%for (FoodStatus status : FoodStatus.values() ) {%>
                                            <option value="<%= status.getValue()%>"><%=status.name()%></option>
                                            <%}%>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label for="saleAt">Sale At</label>
                                        <input type="date" class="form-control " id="saleAt"
                                               placeholder="Sale At" name="saleAt" value="<%= FormatterHelper.formatDate(food.getSaleAt(), "yyyy-MM-dd") %>"
                                        >
                                    </div>
                                    <button type="submit" class="btn btn-primary me-2">Submit</button>
                                    <button class="btn btn-light">Cancel</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- content-wrapper ends -->
            <!-- partial:../../partials/_footer.html -->
           <jsp:include page="/admin/components/footer.jsp" />
            <!-- partial -->
        </div>
    </div>
</div>
<!-- container-scroller -->
<!-- plugins:js -->
<script src="/admin/assets/vendors/js/vendor.bundle.base.js"></script>
<!-- endinject -->
<!-- Plugin js for this page -->
<script src="/admin/assets/vendors/typeahead.js/typeahead.bundle.min.js"></script>
<script src="/admin/assets/vendors/select2/select2.min.js"></script>
<script src="/admin/assets/vendors/bootstrap-datepicker/bootstrap-datepicker.min.js"></script>
<!-- End plugin js for this page -->
<!-- inject:js -->
<script src="/admin/assets/js/off-canvas.js"></script>
<script src="/admin/assets/js/hoverable-collapse.js"></script>
<script src="/admin/assets/js/template.js"></script>
<script src="/admin/assets/js/settings.js"></script>
<script src="/admin/assets/js/todolist.js"></script>
<!-- endinject -->
<!-- Custom js for this page-->
<script src="/admin/assets/js/file-upload.js"></script>
<script src="/admin/assets/js/typeahead.js"></script>
<script src="/admin/assets/js/select2.js"></script>
<script src="https://upload-widget.cloudinary.com/global/all.js" type="text/javascript"></script>
<script>
    ClassicEditor
        .create( document.querySelector( '#editor' ) )
        .then( editor => {
            console.log( editor );
        } )
        .catch( error => {
            console.error( error );
        } );
</script>

<script type="text/javascript">
    var myWidget = cloudinary.createUploadWidget({
            cloudName: 'smiley-face',
            uploadPreset: 'arkkjwlv'}, (error, result) => {
            if (!error && result && result.event === "success") {
                $('#preview-image').attr('src',result.info.secure_url );
                $('#hidden-thumbnails').val(result.info.secure_url);
            }
        }
    )

    document.getElementById("upload_widget").addEventListener("click", function(){
        myWidget.open();
    }, false);
</script>

<!-- End custom js for this page-->
</body>

</html>