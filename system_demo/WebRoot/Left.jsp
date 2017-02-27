<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<link href="Style/Style.css" rel="stylesheet" type="text/css" />
<meta charset="UTF-8">
<title>jQuery可展开收缩三级下拉菜单代码 - 16素材网</title>
<style type="text/css">
*{margin: 0;padding: 0}
body{font-size: 12px;font-family: "宋体","微软雅黑";}
ul,li{list-style: none;}
a:link,a:visited{text-decoration: none;}
.list{width: 210px;border-bottom:solid 1px #316a91;margin:40px auto 0 auto;}
.list ul li{background-color:#467ca2; border:solid 1px #316a91; border-bottom:0;}
.list ul li a{padding-left: 10px;color: #fff; font-size:12px; display: block; font-weight:bold; height:36px;line-height: 36px;position: relative;
}
.list ul li .inactive{ background:url(../Desktop/ce5ec5ec59ae6499ad18a4cd5395f7bd/16sucai.com/images/off.png) no-repeat 184px center;}
.list ul li .inactives{background:url(../Desktop/ce5ec5ec59ae6499ad18a4cd5395f7bd/16sucai.com/images/on.png) no-repeat 184px center;} 
.list ul li ul{display: none;}
.list ul li ul li { border-left:0; border-right:0; background-color:#6196bb; border-color:#467ca2;}
.list ul li ul li ul{display: none;}
.list ul li ul li a{ padding-left:20px;}
.list ul li ul li ul li { background-color:#d6e6f1; border-color:#6196bb; }
.last{ background-color:#d6e6f1; border-color:#6196bb; }
.list ul li ul li ul li a{ color:#316a91; padding-left:30px;}
</style>
<script type="text/javascript" src="../Desktop/ce5ec5ec59ae6499ad18a4cd5395f7bd/16sucai.com/jquery-1.11.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$('.inactive').click(function(){
		if($(this).siblings('ul').css('display')=='none'){
			$(this).parent('li').siblings('li').removeClass('inactives');
			$(this).addClass('inactives');
			$(this).siblings('ul').slideDown(100).children('li');
			if($(this).parents('li').siblings('li').children('ul').css('display')=='block'){
				$(this).parents('li').siblings('li').children('ul').parent('li').children('a').removeClass('inactives');
				$(this).parents('li').siblings('li').children('ul').slideUp(100);

			}
		}else{
			//控制自身变成+号
			$(this).removeClass('inactives');
			//控制自身菜单下子菜单隐藏
			$(this).siblings('ul').slideUp(100);
			//控制自身子菜单变成+号
			$(this).siblings('ul').children('li').children('ul').parent('li').children('a').addClass('inactives');
			//控制自身菜单下子菜单隐藏
			$(this).siblings('ul').children('li').children('ul').slideUp(100);

			//控制同级菜单只保持一个是展开的（-号显示）
			$(this).siblings('ul').children('li').children('a').removeClass('inactives');
		}
	})
});
</script>
</head>
<body>
<div class="list">
	<ul class="yiji">
		<li><a href="#">档案馆管理员管理</a></li>
		<li><a href="#" class="inactive">楼宇管理员管理</a>
			<ul style="display: none">
				<li><a href="#" class="inactive active"></a>
					<ul>
						<li><a href="http://www.16sucai.com">办公室</a></li>
						<li><a href="http://www.16sucai.com">人事处</a></li>
						<li><a href="http://www.16sucai.com">组联部</a></li>
						<li><a href="http://www.16sucai.com">外联部</a></li>
						<li><a href="http://www.16sucai.com">研究部</a></li>
						<li><a href="http://www.16sucai.com">维权办</a></li>
					</ul>
				</li> 
				<li class="last"><a href="#">《美术》杂志社</a></li> 
			</ul>
		</li>
		<li><a href="#" class="inactive">库房管理员管理</a>
			<ul style="display: none">
				<li><a href="#" class="inactive active">美协机关</a>
					<ul>
						<li><a href="#">办公室</a></li>
						<li><a href="#">人事处</a></li>
						<li><a href="#">组联部</a></li>
						<li><a href="#">外联部</a></li>
						<li><a href="#">研究部</a></li>
						<li><a href="#">维权办</a></li>
					</ul>
				</li> 
				<li><a href="#" class="inactive active">中国文联美术艺术中心</a>   
					<ul>
						<li><a href="#">综合部</a></li>
						<li><a href="#">大型活动部</a></li>
						<li><a href="#">展览部</a></li>
						<li><a href="#">艺委会工作部</a></li>
						<li><a href="http://www.16sucai.com">信息资源部</a></li>
						<li><a href="http://www.16sucai.com">双年展办公室</a></li>
					</ul>
				</li> 
				<li class="last"><a href="#">《美术》杂志社</a></li> 
			</ul>
		</li>
	</ul>
</div>

<div style="text-align:center;margin:50px 0; font:normal 14px/24px 'MicroSoft YaHei';">
</div>
</body>