<%@page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>当当图书 – 全球最大的中文网上书店</title>
		<link href="../css/book.css" rel="stylesheet" type="text/css" />
		<link href="../css/second.css" rel="stylesheet" type="text/css" />
		<link href="../css/secBook_Show.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="../js/jquery-1.4.3.js"></script>
	</head>
	<body>
		&nbsp;
		<!-- 头部开始 -->
		<%@include file="../common/head.jsp"%>
		<!-- 头部结束 -->
		<div style="width: 962px; margin: auto;">
			<a href="#" target="_blank"><img
					src="../images/default/book_banner_081203.jpg" border="0" /> </a>
		</div>
        <div class='your_position'>
			您现在的位置:&nbsp;
			<font style='color: #cc3300'><strong>当当图书</strong> </font>&gt;&gt;
			<a href="../main/bookList.do">商品展示</a> 
		</div>
		<div class="book">

			<!--左栏开始-->
			<div id="left" class="book_left">
			</div>
			<!--左栏结束-->

			<!--中栏开始-->
			<div class="book_center">

				<!--推荐图书开始-->
				<div class="second_c_border1" id="recommend">
					<img src="../images/window_loading.gif"></img>正在加载数据
					<script type="text/javascript">
						$("#recommend").load("../main/randomFindBook.do");
					</script>
				</div>

				<!--推荐图书结束-->

				<!--热销图书开始-->
				<div class="book_c_border2" id="hot">
					<img src="../images/window_loading.gif"/>正在加载数据
					<script type="text/javascript">
						$("#hot").load("../main/hotSaleBook.do");
					</script>
				</div>
				<!--热销图书结束-->

				<!--最新上架图书开始-->
				<div class="book_c_border2" id="new">
					<img src="../images/window_loading.gif"/>正在加载数据
					<script type="text/javascript">
						$("#new").load("../main/findNewAddBooks.do");
					</script>
				</div>

				<!--最新上架图书结束-->

				<div class="clear">
				</div>
			</div>
			<!--中栏结束-->



			<!--右栏开始-->
			
				<div class="book_right">
					
				</div>
			
			<!--右栏结束-->
			<div class="clear"></div>
		    </div>

		<!--页尾开始 -->
		<%@include file="../common/foot.jsp"%>
		<!--页尾结束 -->
	</body>
</html>
