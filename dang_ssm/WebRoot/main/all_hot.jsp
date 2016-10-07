<%@page contentType="text/html;charset=utf-8"%>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="../css/book.css1">
	</head>
	<body>
<h2>
	<span class="more"><a href="allHotSaleBook.action" target="_blank">更多&gt;&gt;</a> </span>热销图书
</h2>
<div class="book_c_04">

	<!--热销图书开始-->
	<s:iterator value="%{bkList}">
		<div class="second_d_wai">
			<div class="img">
				<a href="bookDetail.action?bookId=${id }" target='_blank'><img
						src="../productImages/${productPic }" border=0 /> </a>
			</div>
			<div class="shuming">
				<a href="bookDetail.action?bookId=${id }" target="_blank">${productName }</a><a href="#" target="_blank"></a>
			</div>
			<div class="price">
				销量：${productNum }本
			</div>
			<div class="price">
				定价：￥${fixedPriceString }
			</div>
			<div class="dang_price">
				当当价：￥${dangPriceString }
			</div>
		</div>
		<div class="book_c_xy_long"></div>
		<br/>
		<br/>
	</s:iterator>
	<!--热销图书结束-->
	<p>
		<a href="main.jsp">返回主页面</a>
	</p>
</div>
<div class="clear"></div>
</body>
</html>