<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>所有用户管理</title>
<link href="../css/css.css" rel="stylesheet" type="text/css">
<script language="javascript">
	function UserAdd(){
		window.navigate("UserInfo_Add.jsp");
	}
	function del(){
		if(confirm("确定要删除吗?")){
			document.forms[0].action=window.location.href='<%=request.getContextPath()%>
	/Admin/admin?action=delete';
			document.forms[0].submit();
		}
	}
</script>

<script>
	function selectAllNullorReserve(obj, obj2) {
		if (obj != null && obj != "") {
			if (document.getElementsByName(obj) != undefined
					&& document.getElementsByName(obj).length > 0) { //getElementsByName函数的作用按名字查找对象，返回一个数组。
				var userids = document.getElementsByName(obj);
				var selectAll = document.getElementById(obj2);
				if (selectAll.checked == true) {
					for (var i = 0; i < userids.length; i++) {
						if (userids[i].checked == false) {
							userids[i].checked = true;
						}
					}
				} else {
					for (var i = 0; i < userids.length; i++) {
						if (userids[i].checked == true) {
							userids[i].checked = false;
						}
					}
				}

			}

		}
	}
</script>
</head>
<body class="write_bg">
	<form name="form1" method="post"
		action="<%=request.getContextPath()%>/Admin/admin?action=list">
		<input type="hidden" name="source" value="0" />
		<table width="1107" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td height="30"></td>
			</tr>
		</table>
		<table width="850" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td height="20" colspan="2"></td>
			</tr>
			<tr>
				<td width="13" height="30" align="left" valign="top"></td>
				<td width="822" align="left" valign="top" class="text_blod_title">用户管理</td>
			</tr>
			<tr>
				<td height="15" colspan="2" align="center"><img
					src="../img/line.jpg" width="850" height="6"></td>
			</tr>
			<tr>
				<td height="15" colspan="2"></td>
			</tr>
		</table>
		<table width="835" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td width="835" background="../img/wb_01 (3).jpg"><table
						width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="5"></td>
							<td width="4%" height="25" align="left" class="text_cray1">姓名</td>
							<td width="11%" align="left" class="text_cray1"><label>
									<input name="realname" type="text" class="text_cray"
									style="width: 80px" value="${sessionScope.listUser.realname }">
							</label></td>
							<td width="6%" align="center" class="text_cray1">性别</td>
							<td width="6%" align="left" class="text_cray1"><label>
									<select name="sex" class="text_cray">
										<option value="1"
											${sessionScope.listUser.sex=='1'?'selected':'' }>男</option>

										<option value="2"
											${sessionScope.listUser.sex=='2'?'selected':'' }>女</option>
								</select>
							</label></td>
							<td width="9%" align="center" class="text_cray1">证件类型</td>
							<td width="13%" align="left" class="text_cray1"><label>
									<select class="text_cray" name="certType" id="cardType">
										<option value="1"
											${sessionScope.listUser.certType.id=='1'?'selected':'' }>二代身份证</option>
										<option value="2"
											${sessionScope.listUser.certType.id=='2'?'selected':'' }>港澳通行证
										</option>
										<option value="3"
											${sessionScope.listUser.certType.id=='3'?'selected':'' }>台湾通行证</option>
										<option value="4"
											${sessionScope.listUser.certType.id=='4'?'selected':'' }>护照</option>
								</select>
							</label></td>
							<td width="8%" align="center" class="text_cray1">证件号码</td>
							<td width="13%" align="left" class="text_cray1"><label>
									<input name="cert" type="text" class="text_cray"
									style="width: 100px" value="${sessionScope.listUser.cert }">
							</label></td>
							<td width="8%" align="center" class="text_cray1">旅客类型</td>
							<td width="13%" align="left" class="text_blod"><label>
									<select class="text_cray" id="passengerType" name="userType"
									style="width: 100px">
										<option value="1"
											${sessionScope.listUser.userType.id=='1'?'selected':'' }>成人</option>
										<option value="2"
											${sessionScope.listUser.userType.id=='2'?'selected':''}>儿童</option>
										<option value="3"
											${sessionScope.listUser.userType.id=='3'?'selected':''}>学生</option>
										<option value="4"
											${sessionScope.listUser.userType.id=='4'?'selected':''}>残疾军人、伤残人民警察</option>
								</select>
							</label></td>
							<td width="8%" align="center" valign="middle"
								class="text_craybold"><label> <input name="Submit"
									type="submit" class="butcx" value="">
							</label></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td height="20" colspan="11" align="center">&nbsp;</td>
						</tr>
					</table>
					<table width="553" border="1" align="center" cellpadding="0"
						cellspacing="1" bordercolor="#dadada" bgcolor="#FFFFFF">
						<tr align="center">
							<td width="44" height="25" valign="middle" bordercolor="#FFFFFF"
								bgcolor="#FFFFFF" class="text_cray1">选择</td>
							<td width="98" height="25" valign="middle" bordercolor="#FFFFFF"
								bgcolor="#FFFFFF" class="text_cray1">姓名</td>
							<td width="80" height="25" valign="middle" bordercolor="#FFFFFF"
								bgcolor="#FFFFFF" class="text_cray1">性别</td>
							<td width="132" height="25" valign="middle" bordercolor="#FFFFFF"
								bgcolor="#FFFFFF" class="text_cray1">证件类型</td>
							<td width="247" height="25" valign="middle" bordercolor="#FFFFFF"
								bgcolor="#FFFFFF" class="text_cray1">证件号码</td>
							<td width="82" height="25" valign="middle" bordercolor="#FFFFFF"
								bgcolor="#FFFFFF" class="text_cray1">旅客类型</td>
							<td width="89" height="25" valign="middle" bordercolor="#FFFFFF"
								bgcolor="#FFFFFF" class="text_cray1">操作</td>
						</tr>
						<tr align="center">
							<td height="15" colspan="7" bordercolor="#FFFFFF"
								bgcolor="#FFFFFF" class="text_cray1"><img
								src="../img/line1.jpg" width="790" height="6"></td>
						</tr>
						<c:forEach items="${list }" var="e" varStatus="status">
							<tr align="center"
								bgcolor="${status.index%2==0?'#FFFFFF':'#cccccc' }">
								<td bordercolor="#FFFFFF" class="text_cray1"><input
									type="checkbox" name="checkbox" value="${e.id }"
									${e.id==sessionScope.user.id?"disabled":"" }></td>
								<td width="98" bordercolor="#FFFFFF" class="text_cray1">${e.realname }</td>
								<td width="80" bordercolor="#FFFFFF" class="text_cray1">${e.sex=="1"?"男":"女" }</td>
								<td width="132" bordercolor="#FFFFFF" class="text_cray1">${e.certType.content }</td>
								<td width="247" bordercolor="#FFFFFF" class="text_cray1">${e.cert }</td>
								<td width="82" bordercolor="#FFFFFF" class="text_cray1">${e.userType.content }</td>
								<td width="89" bordercolor="#FFFFFF" class="text_cray1"><a
									href="UserManageInfo_Amind_Edit.html" class="text_red">编辑</a></td>
							</tr>
						</c:forEach>


					</table> <br>
					<table width="773" border="0" align="center" cellpadding="0"
						cellspacing="0">
						<tr align="center">
							<td width="102" align="left" class="text_cray1"><a href="#">
									<label></label> <label></label> <label> <input
										type="checkbox" name="checkbox2" value="11" id="selectAll"
										onclick="selectAllNullorReserve('checkbox','selectAll');"><span
										class="text_blue">全选</span></label>
							</a></td>
							<td width="525" align="right" class="text_cray1"><a href="#">
									<!--<input type="button" name="Submit23" value="新增" onClick="UserAdd()"> -->
							</a></td>
							<td width="55" align="right" class="text_cray1"><a href="#">
									<input name="Submit22" type="button" class="butsc" value="">
							</a></td>
							<td width="91" align="right" class="text_cray1"><label>
									<input name="Submit3" type="button" class="butdc" value=""
									onclick="window.location.href='<%=request.getContextPath()%>/Admin/admin?action=export'" />
							</label></td>
						</tr>
					</table> <br>
					<table width="773" border="0" align="center" cellpadding="0"
						cellspacing="0">
						<tr align="center" style="width: 60%">
							<td width="335" align="center" class="text_cray">&nbsp;</td>
							<td width="284" align="center" class="text_cray">>> <c:forEach
									begin="1" end="${pageCount }" var="p">
									<%--当前页样式设定 --%>
									<c:if test="${p==page }">
										<a
											href="<%=request.getContextPath() %>/Admin/admin?action=list&page=${p }"><b>${p }</b></a>
									</c:if>
									<%--非当前页样式设定 --%>
									<c:if test="${p!=page }">
										<a
											href="<%=request.getContextPath() %>/Admin/admin?action=list&page=${p }">${p }</a>
									</c:if>
								</c:forEach> &lt;&lt;

							</td>
							<td width="154" align="right" class="text_cray1"
								style="width: 20%"><label class="text_cray"> 每页显示 <select
									name="pageSize">
										<option value="10"
											${sessionScope.pageSize=='10'?'selected':'' }>10</option>
										<option value="20"
											${sessionScope.pageSize=='20'?'selected':'' }>20</option>
										<option value="30"
											${sessionScope.pageSize=='30'?'selected':'' }>30</option>
								</select> 条信息
							</label></td>
						</tr>
					</table> <br></td>
			</tr>
			<tr>
				<td height="20"></td>
			</tr>
		</table>
		<table width="100%" border="0" cellspacing="0">
			<tr>
				<td height="2" background="../img/bottom_point.gif"></td>
			</tr>
			
			<tr>
				<td height="25" align="center" background="../img/bottom_ny_bg.gif"
					class="text_cray">copyright@12306 购票网</td>
			</tr>
		</table>
	</form>
</body>
</html>