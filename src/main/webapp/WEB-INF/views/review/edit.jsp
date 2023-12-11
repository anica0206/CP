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
    <input id="review-no" type="hidden" value="${review.reviewNo}"/>
    <!-- Sidebar -->
    <ul class="col-2 navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">
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
            <a class="nav-link" href="#">
                <i class="fa fa-id-card-o" aria-hidden="true"></i>
                <span>Profile</span>
            </a>
        </li>

        <!-- community -->
        <li class="nav-item">
            <a class="nav-link" href="/community/list">
                <i class="fa fa-comments-o" aria-hidden="true"></i>
                <span>community</span>
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
            <a class="nav-link" href="/Recommend/">
                <i class="fa fa-compass" aria-hidden="true"></i>
                <span>Program Recommendation</span>
            </a>
        </li>

        <!-- News -->
        <li class= "nav-item">
            <a class="nav-link" href="#">
                <i class="fa fa-newspaper-o" aria-hidden="true"></i>
                <span>News</span>
            </a>
        </li>

        <!-- Divider -->
        <hr class="sidebar-divider">

        <!-- Heading -->
        <div class="sidebar-heading">
            Detail Data
        </div>

        <!-- Nav Item - Charts -->
        <li class="nav-item">
            <a class="nav-link" href="charts.html">
                <i class="fa fa-area-chart" aria-hidden="true"></i>
                <span>Charts</span></a>
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

            <!-- Topbar Search -->
            <form
                    class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
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

                <!-- Nav Item - Alerts -->
                <li class="nav-item dropdown no-arrow mx-1">
                    <a
                            class="nav-link dropdown-toggle"
                            href="#"
                            id="alertsDropdown"
                            role="button"
                            data-toggle="dropdown"
                            aria-haspopup="true"
                            aria-expanded="false">
                        <i class="fas fa-bell fa-fw"></i>
                        <!-- Counter - Alerts -->
                        <span class="badge badge-danger badge-counter">3+</span>
                    </a>
                    <!-- Dropdown - Alerts -->
                    <div
                            class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in"
                            aria-labelledby="alertsDropdown">
                        <h6 class="dropdown-header">Alerts Center</h6>
                        <a class="dropdown-item d-flex align-items-center" href="#">
                            <div class="mr-3">
                                <div class="icon-circle bg-primary">
                                    <i class="fas fa-file-alt text-white"></i>
                                </div>
                            </div>
                            <div>
                                <div class="small text-gray-500">December 12, 2019</div>
                                <span class="font-weight-bold"
                                >A new monthly report is ready to download!</span
                                >
                            </div>
                        </a>
                        <a class="dropdown-item d-flex align-items-center" href="#">
                            <div class="mr-3">
                                <div class="icon-circle bg-success">
                                    <i class="fas fa-donate text-white"></i>
                                </div>
                            </div>
                            <div>
                                <div class="small text-gray-500">December 7, 2019</div>
                                $290.29 has been deposited into your account!
                            </div>
                        </a>
                        <a class="dropdown-item d-flex align-items-center" href="#">
                            <div class="mr-3">
                                <div class="icon-circle bg-warning">
                                    <i class="fas fa-exclamation-triangle text-white"></i>
                                </div>
                            </div>
                            <div>
                                <div class="small text-gray-500">December 2, 2019</div>
                                Spending Alert: We've noticed unusually high spending for
                                your account.
                            </div>
                        </a>
                        <a
                                class="dropdown-item text-center small text-gray-500"
                                href="#"
                        >Show All Alerts</a
                        >
                    </div>
                </li>

                <!-- Nav Item - Messages -->
                <li class="nav-item dropdown no-arrow mx-1">
                    <a
                            class="nav-link dropdown-toggle"
                            href="#"
                            id="messagesDropdown"
                            role="button"
                            data-toggle="dropdown"
                            aria-haspopup="true"
                            aria-expanded="false">
                        <i class="fas fa-envelope fa-fw"></i>
                        <!-- Counter - Messages -->
                        <span class="badge badge-danger badge-counter">7</span>
                    </a>
                    <!-- Dropdown - Messages -->
                    <div
                            class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in"
                            aria-labelledby="messagesDropdown">
                        <h6 class="dropdown-header">Message Center</h6>
                        <a class="dropdown-item d-flex align-items-center" href="#">
                            <div class="dropdown-list-image mr-3">
                                <img
                                        class="rounded-circle"
                                        src="img/undraw_profile_1.svg"
                                        alt="..." />
                                <div class="status-indicator bg-success"></div>
                            </div>
                            <div class="font-weight-bold">
                                <div class="text-truncate">
                                    Hi there! I am wondering if you can help me with a
                                    problem I've been having.
                                </div>
                                <div class="small text-gray-500">Emily Fowler · 58m</div>
                            </div>
                        </a>
                        <a class="dropdown-item d-flex align-items-center" href="#">
                            <div class="dropdown-list-image mr-3">
                                <img
                                        class="rounded-circle"
                                        src="img/undraw_profile_2.svg"
                                        alt="..." />
                                <div class="status-indicator"></div>
                            </div>
                            <div>
                                <div class="text-truncate">
                                    I have the photos that you ordered last month, how would
                                    you like them sent to you?
                                </div>
                                <div class="small text-gray-500">Jae Chun · 1d</div>
                            </div>
                        </a>
                        <a class="dropdown-item d-flex align-items-center" href="#">
                            <div class="dropdown-list-image mr-3">
                                <img
                                        class="rounded-circle"
                                        src="static/img/undraw_profile_3.svg"
                                        alt="..." />
                                <div class="status-indicator bg-warning"></div>
                            </div>
                            <div>
                                <div class="text-truncate">
                                    Last month's report looks great, I am very happy with
                                    the progress so far, keep up the good work!
                                </div>
                                <div class="small text-gray-500">Morgan Alvarez · 2d</div>
                            </div>
                        </a>
                        <a class="dropdown-item d-flex align-items-center" href="#">
                            <div class="dropdown-list-image mr-3">
                                <img
                                        class="rounded-circle"
                                        src="https://source.unsplash.com/Mv9hjnEUHR4/60x60"
                                        alt="..." />
                                <div class="status-indicator bg-success"></div>
                            </div>
                            <div>
                                <div class="text-truncate">
                                    Am I a good boy? The reason I ask is because someone
                                    told me that people say this to all dogs, even if they
                                    aren't good...
                                </div>
                                <div class="small text-gray-500">
                                    Chicken the Dog · 2w
                                </div>
                            </div>
                        </a>
                        <a
                                class="dropdown-item text-center small text-gray-500"
                                href="#"
                        >Read More Messages</a
                        >
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
                  >Douglas McGee</span>
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
            <h1 class="h3 mb-2 text-gray-800">리뷰게시판</h1>
            <p class="mb-4">
                리뷰게시판 입니다. 미풍양속을 해치지 않는 범위 내에서
                작성해주세요.
            </p>

            <!-- DataTales Example -->
            <div class="card shadow mb-4">
                <div class="card-header py-3">
                    <h6 class="m-0 font-weight-bold text-primary">리뷰 쓰기</h6>
                </div>
                <div class="card-body">
                    <div class="table-responsive">
                        <table
                                class="table table-bordered"
                                width="100%"
                                cellspacing="0">
                            <tr>
                                <th>제목</th>
                                <td>
                                    <input id="review-title" name="title" value="${review.title}" type="text" placeholder="제목을 입력하세요." class="form-control">
                                </td>
                            </tr>
                            <tr>
                                <th>수료한 과정 이름</th>
                                <td>
                                    <select id="review-course" class="form-select">
                                        <option value="1">Java</option>
                                        <option value="2">Python</option>
                                        <option value="3">Spring</option>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <th>작성자</th>
                                <td>
                                    <input id="review-username" name="title" value="${review.userId}" type="text" placeholder="" class="form-control">
                                </td>
                            </tr>
                            <tr>
                                <th>내용</th>
                                <td>
                                    <textarea id="review-content" class="form-control" name="message" placeholder="내용을 입력하세요." rows="7">${review.content}</textarea>
                                </td>
                            </tr>
                        </table>
                        <div class="text-right">
                            <button id="review-edit-btn" class="btn btn-primary btn-icon-split">
                                <span class="text">수정</span>
                            </button>

                            <button id="review-cancel-btn" class="btn btn-light btn-icon-split">
                                <span class="text">취소</span>
                            </button>
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
                <a class="btn btn-primary" href="/login.html">Logout</a>
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
    $('#review-edit-btn').on('click', function () {
        if(confirm('글 수정을 하시겠습니까?')) {
            if($('#review-title').val() == '') {
                alert('제목을 입력하세요.');
                return;
            }

            if($('#review-username').val() == '') {
                alert('사용자명을 입력하세요.');
                return;
            }

            if($('#review-content').val() == '') {
                alert('글 내용을 입력하세요.');
                return;
            }

            $.ajax({
                type:"post",
                url:"/review/editDetail",
                contentType: 'application/json',
                data: JSON.stringify({
                    title : $('#review-title').val(),
                    courseNo : $("#review-course option:selected").val(),
                    userId : $('#review-username').val(),
                    content : $('#review-content').val(),
                    reviewNo : $('#review-no').val()
                }),
                dataType:"json",
                success:function(result){
                    if(result.result == 'ok') {

                        location.href='/review'
                    }
                }
            });

        }
    });

    $('#review-cancel-btn').on('click', function () {
        if(confirm('글 수정을 취소하시겠습니까?')) {
            location.href='/review'
        }
    });

</script>

</body>
</html>
