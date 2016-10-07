<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="../css/book.css">
	</head>
	<body>
<h2>
	<span class="more"><a href="allNewAddBook.do" target="_blank">更多&gt;&gt;</a> </span>最新上架图书
</h2>
<div class="book_c_04">

	<!--最新上架图书A开始-->
	<c:forEach items="${books}" var="book">
		<div class="second_d_wai">
			<div class="img">
				<a href="bookDetail.do?bookId=${book.id}" target='_blank'><img
						src="../productImages/${book.id}.jpg" border=0 /> </a>
			</div>
			<div class="shuming">
				<a href="bookDetail.do?bookId=${book.id }" target="_blank" align="center">${book.productName }</a>
			</div>
			<div class="add_time">
				&nbsp;上架日期：${book.publishTime}
			</div>
			<div class="price">
				定价：￥${book.fixedPrice}
			</div>
			<div class="dang_price">
				&nbsp;当当价：￥${book.dangPrice}
			</div>
		</div>
		<div class="book_c_xy_long"></div>
	</c:forEach>
	<!--最新上架图书A结束-->

</div>
<div class="clear"></div>
</body>
</html>