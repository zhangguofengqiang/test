<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h2>
	编辑推荐
</h2>
<div id=__bianjituijian/danpin>
	<div class=second_c_02>
	
	
	
		<!-- 列表开始 -->
		<c:forEach items="${books}" var="book">
			<div class=second_c_02_b1>
				<div class=second_c_02_b1_1>
					<a href='bookDetail.do?bookId=${book.id }' target='_blank'><img src="../productImages/${book.id}.jpg" width=70 border=0 /> </a>
				</div>
				<div class=second_c_02_b1_2>
					<h3>
						<a href='bookDetail.do?bookId=${book.id }' target='_blank'>${book.productName }</a>
					</h3>
					<h4>
						作者：${book.author} 著
						<br />
						出版社：${book.publishing }&nbsp;&nbsp;出版时间：${book.publishTime}
					</h4>
					<div class="edit_introduce" >
						介绍:
						<span >${book.description}</span>
					</div>
					<h6>
						定价：￥${book.fixedPrice}&nbsp;&nbsp;<span class="dang_price">当当价：￥${book.dangPrice}</span>
						
					</h6>
				</div>
			</div>
		</c:forEach>
		<!-- 列表结束 -->	
	</div>
</div>

