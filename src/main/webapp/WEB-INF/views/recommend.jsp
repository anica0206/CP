<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- css,js등등 주소 재료 추가시 /static/을 꼭 붙여줘야함!! -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title> Project 1 - Dashboard</title>

    <!-- Custom fonts for this template-->
    <link href="/static/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            type="text/css" rel="stylesheet">
    <!--    Icon template-->
    <script src="https://kit.fontawesome.com/8fd9460f6d.js" crossorigin="anonymous"></script>
    <!-- Custom styles for this template-->
    <link href="/static/css/sb-admin-2.min.css" type="text/css" rel="stylesheet">


    <!--chartdiv1 Resource-->
    <script src="https://cdn.amcharts.com/lib/5/index.js"></script>
    <script src="https://cdn.amcharts.com/lib/5/xy.js"></script>
    <script src="https://cdn.amcharts.com/lib/5/themes/Animated.js"></script>


</head>

<body id="page-top">

<!-- Page Wrapper -->
<div id="wrapper">

    <!-- Sidebar -->
    <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">
        <a class="sidebar-brand d-flex align-items-center justify-content-center" href="/">
            <div class="sidebar-brand-text mx-3">CareerPath <sup></sup></div>
        </a>
        <hr class="sidebar-divider my-0">
        <li class="nav-item active">
            <a class="nav-link" href="/">
                <i class="fas fa-fw fa-tachometer-alt"></i>
                <span>Dashboard</span>
            </a>
        </li>
        <hr class="sidebar-divider">

        <div class="sidebar-heading">
            Interface
        </div>

        <!-- Profile -->

        <li class="nav-item">
            <a class="nav-link" href="/profile">
                <i class="fa fa-id-card-o" aria-hidden="true"></i>
                <span>Profile</span>
            </a>
        </li>

        <!-- Community -->
        <li class="nav-item">
            <a class="nav-link" href="/community/list">
                <i class="fa fa-comments-o" aria-hidden="true"></i>
                <span>Community</span>
            </a>
        </li>

        <!-- training program Review -->
        <li class="nav-item">
            <a class="nav-link" href="/review/">
                <i class="fa fa-wpexplorer" aria-hidden="true"></i>
                <span>Training Program Review</span>
            </a>
        </li>

        <!-- Training program recommendation -->
        <li class="nav-item">
            <a class="nav-link" href="/recommend">
                <i class="fa fa-compass" aria-hidden="true"></i>
                <span>Program Recommendation</span>
            </a>
        </li>

    </ul>

    <!-- End of Sidebar -->

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="col-10 d-flex flex-column">

        <!-- Main Content -->
        <!-- Topbar -->
        <nav
                class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">
            <!-- Sidebar Toggle (Topbar) -->
            <form class="form-inline">
                <button
                        id="sidebarToggleTop"
                        class="btn btn-link d-md-none rounded-circle mr-3">
                    <i class="fa fa-bars"></i>
                </button>
            </form>

            <!-- Topbar Navbar -->
            <ul class="navbar-nav ml-auto">
                <!-- Nav Item - Search Dropdown (Visible Only XS) -->
                <li class="nav-item dropdown no-arrow d-sm-none">
                    <a
                            class="nav-link dropdown-toggle"
                            href="#"
                            id="searchDropdown"
                            role="button"
                            data-toggle="dropdown"
                            aria-haspopup="true"
                            aria-expanded="false">
                        <i class="fas fa-search fa-fw"></i>
                    </a>
                    <!-- Dropdown - Messages -->
                    <div
                            class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in"
                            aria-labelledby="searchDropdown">
                        <form class="form-inline mr-auto w-100 navbar-search">
                            <div class="input-group">
                                <input
                                        type="text"
                                        class="form-control bg-light border-0 small"
                                        placeholder="Search for..."
                                        aria-label="Search"
                                        aria-describedby="basic-addon2" />
                                <div class="input-group-append">
                                    <button class="btn btn-primary" type="button">
                                        <i class="fas fa-search fa-sm"></i>
                                    </button>
                                </div>
                            </div>
                        </form>
                    </div>
                </li>


                <div class="topbar-divider d-none d-sm-block"></div>

                <!-- Nav Item - User Information -->
                <li class="nav-item dropdown no-arrow">
                    <a
                            class="nav-link dropdown-toggle"
                            href="#"
                            id="userDropdown"
                            role="button"
                            data-toggle="dropdown"
                            aria-haspopup="true"
                            aria-expanded="false">
                  <span class="mr-2 d-none d-lg-inline text-gray-600 small"
                  >${user.userId}</span>
                        <img class="img-profile rounded-circle"
                             src="/static/img/undraw_profile.svg">
                    </a>
                    <!-- Dropdown - User Information -->
                    <div
                            class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                            aria-labelledby="userDropdown">
                        <a class="dropdown-item" href="#">
                            <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                            Profile
                        </a>
                        <a class="dropdown-item" href="#">
                            <i class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
                            Settings
                        </a>
                        <a class="dropdown-item" href="#">
                            <i class="fas fa-list fa-sm fa-fw mr-2 text-gray-400"></i>
                            Activity Log
                        </a>
                        <div class="dropdown-divider"></div>
                        <a
                                class="dropdown-item"
                                href="#"
                                data-toggle="modal"
                                data-target="#logoutModal">
                            <i
                                    class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                            Logout
                        </a>
                    </div>
                </li>
            </ul>
        </nav>
         <!-- Begin Page Content -->
              <div class="container-fluid">
                <!-- Page Heading -->
                <h1 class="h3 mb-2 text-gray-800">훈련과정 추천</h1>
                <p class="mb-4">
                  희망하는 직종이랑 지역을 설정 검색 버튼 눌러주세요.
                </p>

                <!-- DataTales Example -->
                <form id="recommend" action="/recommend/getCourses" method="get">
                <div class="card shadow mb-4">
                  <div class="card-header py-3">
                    <div class="row justify-content-end">
                        <div class="col-4">
                            <select
                                 id="wantedJob" name="wantedJob"
                                 class="btn btn-outline-primary dropdown-toggle"
                                 aria-labelledby="dropdownArea">
                                 <option value="" selected disabled>희망 직종</option>
                                    <c:forEach items="${jobs}" var="job">
                                        <option value="${job.jobName}">${job.jobName}</option>
                                    </c:forEach>

                            </select>
                        </div>
                        <div class="col-4">
                            <div class="row justify-content-start">
                                <div class="col-4">
                                    <select
                                        id="wantedArea" name="wantedArea"
                                        class="btn btn-outline-primary dropdown-toggle"
                                        aria-labelledby="dropdownArea">
                                        <option value="" selected disabled>희망 지역</option>
                                        <c:forEach items="${academys}" var="academy">
                                            <option value="${academy.area}">${academy.area}</option>
                                        </c:forEach>
                                        </optgroup>
                                    </select>
                                </div>


                                <button onclick="document.getElementById('recommend').submit()" id="getCourses_btn" class="btn btn-primary">
                                    <i class="fas fa-search fa-sm"></i>
                                  </button>
                                  </div>
                            </div>
                            </form>
                        </div>
                      </div>
                  </div>
                  <div class="card-body">
                    <div class="table-responsive">

                    </br>
                    <div class="table-responsive">
                      <table
                        class="table table-bordered"
                        width="100%"
                        cellspacing="0">
                        <thead>
                            <tr>
                                <th></th>
                                <th>과정이름</th>
                                <th>학원이름</th>
                                <th>지역</th>
                                <th>관련직종</th>
                              </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${courses}" var="recommend">
                                <tr>
                                    <th scope="row">${recommend.rowNum}</th>
                                    <td>${recommend.courseName}</td>
                                    <td>${recommend.academyName}</td>
                                    <td>${recommend.area}</td>
                                    <td>${recommend.jobName}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                      </table>
                    </div>
                  </div>
                </div>
              </div>
              <!-- /.container-fluid -->
            </div>
            <!-- End of Main Content -->


            <!-- Footer -->
            <!-- End of Footer -->
        </div>
        <!-- End of Content Wrapper -->
    </div>
</div>
    <!-- End of Page Wrapper -->
    <footer class="sticky-footer bg-white">
        <div class="container my-auto">
            <div class="copyright text-center my-auto">
                <span>Copyright &copy; Your Website 2021</span>
            </div>
        </div>
    </footer>
    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>

    <!-- Logout Modal-->
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
         aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                    <form id="logout" action="/logout" method="post">
                       <a href="#" onclick="document.getElementById('logout').submit()" class="btn btn-primary">Logout</a>
                    </form>
                </div>
            </div>
        </div>
    </div>



    <!-- Bootstrap core JavaScript-->
    <script src="/static/vendor/jquery/jquery.min.js"></script>
    <script src="/static/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="/static/vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="/static/js/sb-admin-2.min.js"></script>

    <!-- Page level plugins -->
    <script src="/static/vendor/chart.js/Chart.min.js"></script>

    <!-- Page level custom scripts -->
    <script src="/static/js/demo/chart-area-demo.js"></script>
    <script src="/static/js/demo/chart-pie-demo.js"></script>


</body>
</html>
