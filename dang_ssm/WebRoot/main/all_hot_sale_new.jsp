<%@page pageEncoding="utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="book_r_border2" id="__XinShuReMai">
						<div class="book_r_b2_1x" id="new_bang">
							<h2 class="t_xsrm">
								新书热卖榜
							</h2>
							<div id="NewProduct_1_o_t" onmouseover="">
							
							<c:forEach items="${books}" var="book">
								<div class="new_book_sale">									
									&nbsp;&nbsp;&nbsp;&nbsp;
									  ${book.productName }  (${book.productNum }本)
								</div>
							</c:forEach>
							
								<h3 class="second1">
									<span class="dot_r1"> </span>
									<a href="main.jsp" target="_blank">返回</a>
								</h3>
							</div>
						</div>
					</div>