<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>

<style>
    body {
        font-family: Arial, sans-serif;
        padding: 30px;
        background-color: #f9f9f9;
    }

    h2 {
        margin-bottom: 20px;
    }

    table {
        width: 100%;
        border-collapse: collapse;
        background: white;
    }

    th, td {
        padding: 12px;
        border-bottom: 1px solid #ddd;
        text-align: center;
    }

    th {
        background-color: #333;
        color: white;
    }

    tr:hover {
        background-color: #f1f1f1;
    }

    .write-btn {
        display: inline-block;
        margin-top: 15px;
        padding: 10px 15px;
        background-color: #007bff;
        color: white;
        text-decoration: none;
        border-radius: 5px;
    }

    .write-btn:hover {
        background-color: #0056b3;
    }
</style>

</head>
<body>

<h2>📌 게시판 목록</h2>

<table>
    <thead>
        <tr>
            <th>번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>작성일</th>
            <th>조회수</th>
        </tr>
    </thead>

    <tbody>
        <!-- 게시글 목록 반복 출력 -->
        <c:forEach var="board" items="${boardList}">
            <tr>
                <td>${board.id}</td>

                <td>
                    <a href="detail?id=${board.id}">
                        ${board.title}
                    </a>
                </td>

                <td>${board.writer}</td>
                <td>${board.createdAt}</td>
                <td>${board.viewCount}</td>
            </tr>
        </c:forEach>

        <!-- 게시글이 없을 때 -->
        <c:if test="${empty boardList}">
            <tr>
                <td colspan="5">게시글이 없습니다.</td>
            </tr>
        </c:if>
    </tbody>
</table>

<!-- 글쓰기 버튼 -->
<a href="writeForm" class="write-btn">✏ 글쓰기</a>

</body>
</html>
