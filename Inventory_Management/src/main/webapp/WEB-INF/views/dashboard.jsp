<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html lang="en" dir="ltr">

    <head>
        <meta charset="UTF-8">
        <title>Dashboard</title>
        <link href='https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css' rel='stylesheet'>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <style>
            @import url('https://fonts.googleapis.com/css2?family=Poppins:wght@200;300;400;500;600;700&display=swap');
            * {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    font-family: 'Poppins', sans-serif;
}

.sidebar {
    position: fixed;
    height: 100%;
    width: 240px;
    background: #0A2558;
    transition: all 0.5s ease;
}

.sidebar.active {
    width: 60px;
}

.sidebar .logo-details {
    height: 80px;
    display: flex;
    align-items: center;
}

.sidebar .logo-details i {
    font-size: 28px;
    font-weight: 500;
    color: #fff;
    min-width: 60px;
    text-align: center
}

.sidebar .logo-details .logo_name {
    color: #fff;
    font-size: 24px;
    font-weight: 500;
    padding-left:15px;
}

.sidebar .nav-links {
    margin-top: 10px;
}

.sidebar .nav-links li {
    position: relative;
    list-style: none;
    height: 50px;
}

.sidebar .nav-links li a {
    height: 100%;
    width: 100%;
    display: flex;
    align-items: center;
    text-decoration: none;
    transition: all 0.4s ease;
}

.sidebar .nav-links li a.active {
    background: #081D45;
}

.sidebar .nav-links li a:hover {
    background: #081D45;
}

.sidebar .nav-links li i {
    min-width: 60px;
    text-align: center;
    font-size: 18px;
    color: #fff;
}

.sidebar .nav-links li a .links_name {
    color: #fff;
    font-size: 15px;
    font-weight: 400;
    white-space: nowrap;
}

.sidebar .nav-links .log_out {
    position: absolute;
    bottom: 0;
    width: 100%;
}

.home-section {
    position: relative;
    background: #f5f5f5;
    min-height: 100vh;
    width: calc(100% - 240px);
    left: 240px;
    transition: all 0.5s ease;
}

.sidebar.active~.home-section {
    width: calc(100% - 60px);
    left: 60px;
}

.home-section nav {
    display: flex;
    justify-content: space-between;
    height: 80px;
    background: #fff;
    display: flex;
    align-items: center;
    position: fixed;
    width: calc(100% - 240px);
    left: 240px;
    z-index: 100;
    padding: 0 20px;
    box-shadow: 0 1px 1px rgba(0, 0, 0, 0.1);
    transition: all 0.5s ease;
}

.sidebar.active~.home-section nav {
    left: 60px;
    width: calc(100% - 60px);
}

.home-section nav .sidebar-button {
    display: flex;
    align-items: center;
    font-size: 24px;
    font-weight: 500;
}

nav .sidebar-button i {
    font-size: 35px;
    margin-right: 10px;
}

.home-section nav .profile-details {
    display: flex;
    align-items: center;
    background: #F5F6FA;
    border: 2px solid #EFEEF1;
    border-radius: 6px;
    height: 50px;
    min-width: 190px;
    padding: 0 15px 0 2px;
}

nav .profile-details img {
    height: 40px;
    width: 40px;
    border-radius: 6px;
    object-fit: cover;
}

nav .profile-details .admin_name {
    font-size: 15px;
    font-weight: 500;
    color: #333;
    margin: 0 10px;
    white-space: nowrap;
}

nav .profile-details i {
    font-size: 25px;
    color: #333;
}

.home-section .home-content {
    position: relative;
    padding-top: 104px;
}


@media (max-width: 1000px) {
    .overview-boxes .box {
        width: calc(100% / 2 - 15px);
        margin-bottom: 15px;
    }
}

@media (max-width: 700px) {

    nav .sidebar-button .dashboard,
    nav .profile-details .admin_name,
    nav .profile-details i {
        display: none;
    }

    .home-section nav .profile-details {
        height: 50px;
        min-width: 40px;
    }

    .home-content .sales-boxes .sales-details {
        width: 560px;
    }
}

@media (max-width: 550px) {
    .overview-boxes .box {
        width: 100%;
        margin-bottom: 15px;
    }

    .sidebar.active~.home-section nav .profile-details {
        display: none;
    }
}

@media (max-width: 400px) {
    .sidebar {
        width: 0;
    }

    .sidebar.active {
        width: 60px;
    }

    .home-section {
        width: 100%;
        left: 0;
    }

    .sidebar.active~.home-section {
        left: 60px;
        width: calc(100% - 60px);
    }

    .home-section nav {
        width: 100%;
        left: 0;
    }

    .sidebar.active~.home-section nav {
        left: 60px;
        width: calc(100% - 60px);
    }
}

img {
    border: 1px solid #ddd;
    border-radius: 8px;
    padding: 5px;
    width: 1270px;
    height: 620px;
}
        </style>
    </head>

    <body>
        <div class="sidebar">
            <div class="logo-details">
                <span class="logo_name">Inventory Management </span>
            </div>
            <ul class="nav-links">
                <li>
                    <a href="dashboard" class="active">
                        <i class='bx bx-grid-alt'></i>
                        <span class="links_name">Dashboard</span>
                    </a>
                </li>
                <li>
                    <a href="addRawMaterial">
                        <i class='bx bx-box'></i>
                        <span class="links_name">Add Raw Material</span>
                    </a>
                </li>

                <li>
                    <a href="addProcessed">
                        <i class='bx bx-box'></i>
                        <span class="links_name">Add Processed Item</span>
                    </a>
                </li>

                <li>
                    <a href="viewRaw">
                        <i class='bx bx-book-alt'></i>
                        <span class="links_name">View Raw Material</span>
                    </a>
                </li>

                <li>
                    <a href="viewProcessed">
                        <i class='bx bx-book-alt'></i>
                        <span class="links_name">View Processed Items</span>
                    </a>
                </li>

                <li>
                    <a href="issueRaw">
                        <i class='bx bx-list-ul'></i>
                        <span class="links_name">Issue Raw Material</span>
                    </a>
                </li>

                <li>
                    <a href="issueProcessed">
                        <i class='bx bx-list-ul'></i>
                        <span class="links_name">Issue Processed Items</span>
                    </a>
                </li>

                <li>
                    <a href="viewRawLog">
                        <i class='bx bx-user'></i>
                        <span class="links_name">View Logs [ Raw ]</span>
                    </a>
                </li>

                <li>
                    <a href="viewLogProcessed">
                        <i class='bx bx-user'></i>
                        <span class="links_name">View Logs [ Processed ]</span>
                    </a>
                </li>



                <li>
                    <a href="unavailable">
                        <i class='bx bx-coin-stack'></i>
                        <span class="links_name">Unavailable Items </span>
                    </a>
                </li>

                <li class="log_out">
                    <a href="index">
                        <i class='bx bx-log-out'></i>
                        <span class="links_name">Log out</span>
                    </a>
                </li>
            </ul>
        </div>

        <section class="home-section">

            <nav>
                <div class="sidebar-button">
                    <i class='bx bx-menu sidebarBtn'></i>
                    <span class="dashboard">Dashboard</span>
                </div>
                <div class="profile-details">
                    <span class="admin_name"><b>[ Manager Name ]</b></span>
                </div>
            </nav>
            <div class="home-content">
                <div class="img">
                <img src="https://tse3.mm.bing.net/th?id=OIP.eZ_kuTtCKZWQ1A3_w_fdyQHaHQ&pid=Api&P=0">
                </div>
            </div>
        </section>

        <script>
            let sidebar = document.querySelector(".sidebar");
            let sidebarBtn = document.querySelector(".sidebarBtn");
            sidebarBtn.onclick = function () {
                sidebar.classList.toggle("active");
                if (sidebar.classList.contains("active")) {
                    sidebarBtn.classList.replace("bx-menu", "bx-menu-alt-right");
                } else
                    sidebarBtn.classList.replace("bx-menu-alt-right", "bx-menu");
            }
        </script>

    </body>

    </html>    