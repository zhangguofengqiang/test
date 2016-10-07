<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="../css/book.css1"> 
		
	</head>
	<body>
<h2>
	<span class="more"><a href="#" target="_blank">更多&gt;&gt;</a> </span>最新上架图书
</h2>
<div class="book_c_04">

	<!--最新上架图书A开始-->
	<c:forEach items="${books}" var="book">
		<div class="second_d_wai">
			<div class="img">
				<a href="bookDetail.do?bookId=${book.id }" target='_blank'>
				<img src="../productImages/${book.id}.jpg" border=0 /> </a>
			</div>
			<div class="shuming">
				<a href="bookDetail.do?bookId=${book.id }" target="_blank">${book.productName }</a><a href="#" target="_blank"></a>
			</div>
			<div class="price">
				上架日期：${book.addTime}
			</div>
			<div class="price">
				定价：￥${book.fixedPrice}
			</div>
			<div class="dang_price">
				当当价：￥${book.dangPrice}
			</div>
		</div>
		<div class="book_c_xy_long"></div>
		<br/>
	</c:forEach>
	<!--最新上架图书A结束-->
	<p>
		<a href="main.jsp">返回主页面</a>
	</p>

</div>
<div class="clear"></div>
</body>
</html>