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
									书的名称：  
									<a href="bookDetail.do?bookId=${book.id }" target="_blank">
										${book.productName }
									</a>
									书的数量：
									(${book.productNum }本)
								</div>
							</c:forEach>
							
								<h4 class="second111">
									<span class="dot_r11111"> </span>
									
									<br/>
									<div class="more">
										<a href="allHotSaleNewBook.do" target="_blank">
										更多&gt;&gt;</a>
									</div>
								</h4>
							</div>
						</div>
					</div>