<jsp:useBean id="user" scope="session" type="com.wj.domain.User"/>
<%--
  Created by IntelliJ IDEA.
  User: ${USER}
  Date: ${DATE}
  Time: ${TIME}
  To change this template use File | Settings | File Templates....
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>论坛</title>
    <script language="javascript">
        function check(f){
            if( f.file.value == '' ){
                alert('请先上传文件')
                return false;
            }
        }
    </script>
</head>
<body>
<c:if test ="${!empty info}">
    <font color="green"><c:out value="${info}"/></font>
</c:if>
      ${user.userName},您好！您的积分为${user.credits}!!,${user.password}

      <form  action="<c:url value='/entryExcel.html'/>"method="post" enctype="multipart/form-data" th:method="GET"
             onsubmit="return check(this)">
          <input type="file" name="file">
          <input type="submit" value="导入excel" >
      </form>
</body>
</html>