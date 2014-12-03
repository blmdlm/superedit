<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>采编系统</title>

<link rel="stylesheet" href="res/css/index.css" type="text/css" media="screen" />

<script type="text/javascript" src="res/js/jquery.min.js"></script>
<script type="text/javascript" src="res/js/tendina.min.js"></script>
<script type="text/javascript" src="res/js/common.js"></script>

</head>
<body>
    <!--顶部-->
    <div class="layout_top_header">
            <div style="float: left"><span style="font-size: 16px;line-height: 45px;padding-left: 20px;color: #8d8d8d">QuickEdit管理后台</h1></span></div>
            <div id="ad_setting" class="ad_setting">
                <a class="ad_setting_a" href="javascript:; ">
                    <i class="icon-user glyph-icon" style="font-size: 20px"></i>
                    <span>${j_user.name}</span>
                    <i class="icon-chevron-down glyph-icon"></i>
                </a>
                <ul class="dropdown-menu-uu" style="display: none" id="ad_setting_ul">
                    <li class="ad_setting_ul_li"> <a href="javascript:;"><i class="icon-user glyph-icon"></i> 个人中心 </a> </li>
                    <li class="ad_setting_ul_li"> <a href="javascript:;"><i class="icon-cog glyph-icon"></i> 设置 </a> </li>
                    <li class="ad_setting_ul_li"> <a href="javascript:;"><i class="icon-signout glyph-icon"></i> <span class="font-bold">退出</span> </a> </li>
                </ul>
            </div>
    </div>
    <!--顶部结束-->
    <!--菜单-->
    <div class="layout_left_menu">
        <ul id="menu">
            <li class="childUlLi">
               <a href="B_personIfo"  target="menuFrame"><i class="glyph-icon icon-home"></i>首页</a>
                <ul>
                    <li><a href="B_personIfo" target="menuFrame"><i class="glyph-icon icon-chevron-right"></i>首页</a></li>
                </ul>
            </li>
            <li class="childUlLi">
                <a href="B_personIfo"  target="menuFrame"> <i class="glyph-icon icon-reorder"></i>用户中心</a>
                <ul>
                	<li><a href="#" target="menuFrame"><i class="glyph-icon icon-chevron-right"></i>消息</a></li>
                    <li><a href="#" target="menuFrame"><i class="glyph-icon icon-chevron-right"></i>查看个人资料</a></li>
                    <li><a href="#" target="menuFrame"><i class="glyph-icon icon-chevron-right"></i>修改个人资料</a></li>
                    <li><a href="#" target="menuFrame"><i class="glyph-icon icon-chevron-right"></i>修改密码</a></li>
                    
                </ul>
            </li>
            
            <li class="childUlLi">
                <a href="B_personIfo"  target="menuFrame"> <i class="glyph-icon icon-reorder"></i>稿费管理</a>
                <ul>
                	<li><a href="financial/paymentmanager/set" target="menuFrame"><i class="glyph-icon icon-chevron-right"></i>设置稿费</a></li>
                    <li><a href="financial/paymentmanager/unpay" target="menuFrame"><i class="glyph-icon icon-chevron-right"></i>待支付稿件</a></li>
                    <li><a href="financial/paymentmanager/payed" target="menuFrame"><i class="glyph-icon icon-chevron-right"></i>已支付稿件</a></li>
                    
                </ul>
            </li>
            

        </ul>
    </div>
    <!--菜单-->
           
    <div id="layout_right_content" class="layout_right_content">

        <div class="route_bg">
            <a href="B_index">首页</a><i class="glyph-icon icon-chevron-right"></i>
        </div>
        
        <!-- 主要内容 -->
        <div class="mian_content">
            <div id="page_content">

                <!--引入界面-->
                <iframe id="menuFrame" name="menuFrame" src="res/img/girl02.jpg" style="overflow:visible;"
                        scrolling="yes" frameborder="no" width="100%" height="100%"></iframe>
            </div>
        </div>
        
        
        
    </div>
    <div class="layout_footer">
        <p>Copyright © 2014 - XXXX科技</p>
    </div>
</body>
</html>