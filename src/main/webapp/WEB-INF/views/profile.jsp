<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<html>
<head>
    <!-- css,js등등 주소 소스 추가시 /static/을 꼭 붙여줘야함!! -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>CareerPath::Profile</title>

    <!-- Custom fonts for this template-->
    <link href="/static/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            type="text/css" rel="stylesheet">
    <!--    Icon template-->
    <script src="https://kit.fontawesome.com/8fd9460f6d.js" crossorigin="anonymous"></script>
    <!-- Custom styles for this template-->
    <link href="/static/css/sb-admin-2.css" type="text/css" rel="stylesheet">
    <script src="/static/https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
    <script src="/static/https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="/static/sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>
    <link rel="stylesheet"
        href="/static/https://s3.ap-northeast-2.amazonaws.com/materials.spartacodingclub.kr/easygpt/default.css" />
    <link href="/static/https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous" />
    <link rel="stylesheet" href="/static/css/style.css">


    <!--chartdiv1 Resource-->
    <script src="https://cdn.amcharts.com/lib/5/index.js"></script>
    <script src="https://cdn.amcharts.com/lib/5/xy.js"></script>
    <script src="https://cdn.amcharts.com/lib/5/themes/Animated.js"></script>
    <!-- chartdiv1 End-->


    <!-- Styles -->

    <!-- /Styles -->
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
        <div id="content">

            <!-- Topbar -->
            <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                <!-- Sidebar Toggle (Topbar) -->
                <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                    <i class="fa fa-bars"></i>
                </button>

                <!-- Topbar Search -->

                <!-- Topbar Navbar -->
                <ul class="navbar-nav ml-auto">

                    <!-- Nav Item - Search Dropdown (Visible Only XS) -->
                    <li class="nav-item dropdown no-arrow d-sm-none">
                        <a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button"
                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <i class="fas fa-search fa-fw"></i>
                        </a>
                        <!-- Dropdown - Messages -->
                        <div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in"
                             aria-labelledby="searchDropdown">
                            <form class="form-inline mr-auto w-100 navbar-search">
                                <div class="input-group">
                                    <input type="text" class="form-control bg-light border-0 small"
                                           placeholder="Search for..." aria-label="Search"
                                           aria-describedby="basic-addon2">
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
                        <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <span class="mr-2 d-none d-lg-inline text-gray-600 small">${user.name}</span>
                            <img class="img-profile rounded-circle"
                                 src="/static/img/undraw_profile.svg">
                        </a>
                        <!-- Dropdown - User Information -->
                        <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                             aria-labelledby="userDropdown">
                            <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
                                <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                Logout
                            </a>
                        </div>
                    </li>

                </ul>

            </nav>
            <!-- End of Topbar -->

            <!-- Begin Page Content -->
            <div class="container">
                <div class="container mt-5">
                    <div class="row justify-content-center">
                        <!-- 프로필 카드 -->
                        <div class="card-custom-size">
                            <div class="card">
                                <div class="text-center">
                                    <img src="https://cdn-icons-png.flaticon.com/512/3106/3106773.png" width="300" height="300">
                                </div>
                                <div class="card-body">
                                    <h5 class="card-title">${user.name}</h5>
                                    <select id="jobs" name="dJob" class="form-select">
                                        <c:forEach items="${jobs}" var="job">
                                            <option value=${job.jobName}>${job.jobName}</option>
                                        </c:forEach>
                                    </select>
                                    <%--<h6 class="card-subtitle mb-2 text-muted"> </h6>--%>
                                    <textarea id="profile-comments" class="form-control" name="comments"
                                                                     placeholder="자유롭게 입력하세요." rows="7"></textarea> <br>
                                    <select id="courses" name="courseNo" class="form-select">
                                        <c:forEach items="${courses}" var="course">
                                            <option value=${course.courseNo}>${course.courseName} - ${course.academyName}</option>
                                        </c:forEach>
                                    </select> <br> <br>

                                    <select id="education" name="education" class="form-select">
                                        <option value="대졸">대졸</option>
                                        <option value="고졸">고졸</option>
                                    </select>

                                    <div style="border-top: 1px solid #dee2e6; margin-top: auto; margin-bottom: 7px;"></div>
                                    <h6 class="card-subtitle mb-2 text-muted"></h6>
                                    <div style="border-top: 1px solid #dee2e6; margin-top: auto; margin-bottom: 5px;"></div>
                                    <div class="text-end">
                                        <button id="profile-save-btn" class="btn btn-primary btn-icon-split">
                                            <span class="text">작성</span>
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

        <!-- Footer -->

        <!-- End of Footer -->

            </div>
        </div>
    </div>
    </div>
            <!-- End of Content Wrapper -->
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

<script>
    $('#profile-save-btn').on('click', function () {
        if (confirm('글 등록을 하시겠습니까?')) {

            console.log($('#courses option:selected').val());
            console.log($('#profile-comments').val());
            console.log($('#jobs option:selected').val());
            console.log($('#education option:selected').val());
            $.ajax({
                type: "post",
                url: "/profile/add",
                contentType: 'application/json',
                data: JSON.stringify({
                    education: $('#education option:selected').val(),
                    comments: $('#profile-comments').val(),
                    dJob: $('#jobs option:selected').val(),
                    courseNo: $('#courses option:selected').val()
                }),
                dataType: "json",
                success: function (result) {
                    if (result.result == 'ok') {

                        location.href = '/profile'
                        //작성후 원래위치로 돌아가게함?
                    }
                }
            });

        }
    });


</script>

</body>

</html>
