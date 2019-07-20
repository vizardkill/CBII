<% if(session.getAttribute("username_usuario") == null) 
   {
     response.sendRedirect("../../index.html");
   }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">


<%@include file="Head.jsp" %>
<%@include file="Modal.jsp" %>

<body>
    <!--Bloque necesario para El efecto Sidebar-->
    <div class="page-wrapper cool-theme sidebar-bg bg6 toggled">

        <!--Sidebar Menu-->
        <%@include file="Menu.jsp" %>
        <!--/Sidebar Menu-->

        <!-- Contenido  -->
        <main class="page-content">
            <div class="container-fluid">

                <section>
                    <div class="row">
                        <div class="col">
                            <h1 class="h1"><i class="fas fa-chalkboard-teacher"></i><strong> Gestión de
                                    Solicitudes</strong> </h1>
                            <nav aria-label="breadcrumb">
                                <ol class="breadcrumb">
                                    <li class="breadcrumb-item"><a href="Inicio.jsp">Inicio</a></li>
                                </ol>
                            </nav>
                        </div>
                    </div>
                </section>

                <hr class="hr blue-grey">

                <section>
                    <div class="row">
                        <div class="col">
                            <div class="btn-group btn-group-sm" role="group" aria-label="Basic example">
                                <button type="button" class="btn btn-primary btn-sm" data-toggle="modal"
                                    data-target="#mod_form_reg_sol">Registrar nueva Solicitud
                                </button>

                            </div>
                        </div>
                    </div>
                    <br>
                </section>

                <section>
                    <div class="row">
                        <div class="col">
                            <table id="table_solicitudes" class="table table-striped table-hover table-responsive-sm">
                                <thead class="thead-dark">
                                    <tr>
                                        <th></th>
                                        <th>Fecha de Creacion</th>
                                        <th>Título</th>
                                        <th>Descripción del Problema</th>
                                        <th>Descripción de la Petición</th>
                                        <th>Acciones</th>
                                    </tr>
                                </thead>
                                <tfoot class="thead-dark">
                                    <tr>
                                        <th></th>
                                        <th>Fecha de Creacion</th>
                                        <th>Título</th>
                                        <th>Descripción del Problema</th>
                                        <th>Descripción de la Petición</th>
                                        <th>Acciones</th>
                                    </tr>
                                </tfoot>
                                <tbody>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </section>
  



            </div>
        </main>
        <!-- /Contenido" -->
    </div>
    <!--/Bloque necesario para El efecto Sidebar-->
</body>

<%@include file="Footer.jsp" %>


</html>