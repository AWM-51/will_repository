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
</head>
<body>
      ${user.userName},您好！您的积分为${user.credits}!!,${user.password}
</body>
</html>