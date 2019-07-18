<!--Modal de Registro de Solicitudes-->
<div class="modal fade" id="mod_form_reg_sol" tabindex="-1" role="dialog" aria-labelledby="mod_form_reg_usuario"
    aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content rounded ">

            <form id="form_reg_sol" name="form_reg_sol" method="POST"
                action="Register?Peticion=Registro_Solicitud">
                <!--Header-->
                <div class="modal-header bg-dark d-block">
                    <button type="button" class="close text-white" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                    <h4 class="text-center text-white"><strong>Formulario de Registro</strong></h4>
                </div>
                <!--/Header-->
                <!--Body-->
                <div class="modal-body mx-3">
                    <div class="container">
                        <div class="row">
                            <input type="hidden" name="form_reg_sol_fk_usuario_solicitante">
                            ${sessionScope['NICK_USER']}
                            </input>
                            <input type="hidden" name="form_reg_sol_fk_estado" value="1">


                            <div class="col-12">
                                <div class="form-group">
                                    <select id="form_reg_sol_fk_categoria" name="form_reg_sol_fk_categoria"
                                        class="browser-default custom-select form-control">
                                        <option value="">Seleccione la categoria</option>
                                    </select>
                                </div>
                            </div>

                            <div class="col-12">
                                <div class="form-group">
                                    <select id="form_reg_sol_fk_programa_academico"
                                        name="form_reg_sol_fk_programa_academico"
                                        class="browser-default custom-select custom-select form-control">
                                        <option value="">Seleccione el programa acad&#233mico</option>
                                    </select>
                                </div>
                            </div>

                            <div class="col-12">
                                <div class="md-form form-group">
                                    <input type="text" id="form_reg_sol_titulo" name="form_reg_sol_titulo"
                                        class="form-control" aria-describedby="form_reg_sol_titulo">
                                    <label for="form_reg_sol_titulo">T&#237tulo</label>
                                </div>

                            </div>

                            <div class="col-12">
                                <div class="md-form form-group">
                                    <i class="fas fa-pencil-alt prefix"></i>
                                    <textarea id="form_reg_sol_descripcion_problema"
                                        name="form_reg_sol_descripcion_problema" class="md-textarea form-control"
                                        rows="3"></textarea>
                                    <label for="form_reg_sol_descripcion_problema">Descripci&#243n del Problema</label>
                                </div>
                            </div>

                            <div class="col-12">
                                <div class="md-form form-group">
                                    <i class="fas fa-pencil-alt prefix"></i>
                                    <textarea id="form_reg_sol_descripcion_peticion"
                                        name="form_reg_sol_descripcion_peticion" class="md-textarea form-control"
                                        rows="3"></textarea>
                                    <label for="form_reg_sol_descripcion_peticion">Descripci&#243n de la
                                        Solicitud</label>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
                <!--/Body-->
                <!--Footer-->
                <div class="modal-footer">
                    <div class="container">
                        <div class="row">
                            <div class="col d-flex flex-center mx-auto">
                                <button id="btn_submit_form_reg_sol" class="btn btn-dark-green"
                                    type="submit">Enviar</button>
                                <i id="icon_load_form_reg_sol"
                                    class="fa fa-spinner fa-spin d-none text-center mx-auto"></i>
                            </div>
                        </div>
                    </div>
                </div>
                <!--/Footer-->
            </form>
        </div>
    </div>
</div>
<!--/Modal de Registro de Usuario-->