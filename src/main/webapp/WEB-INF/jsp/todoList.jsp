<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
	<div>
		<a type="button" class="btn btn-primary btn-md" href="/addTodo">Add Todo</a>
	</div>
	<br>
	<div class="panel panel-primary">
		<div class="panel-heading">
			<h3>List of TODO's</h3>
		</div>
		<div class="panel-body">
			<table class="table table-striped">
				<thead>
					<tr>
						<th width="20%">Description</th>
						<th width="20%">Start Date</th>
						<th width="20%">Target Date</th>
						<th width="20%">Status</th>
						<th width="20%"></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${todos}" var="todo">
						<tr>
							<td>${todo.description}</td>
							<td><fmt:formatDate value="${todo.startDate}"
									pattern="yyyy-MM-dd" /></td>
							<td><fmt:formatDate value="${todo.endDate}"
									pattern="yyyy-MM-dd" /></td>
							<td>${todo.status}</td>
							<td><a type="button" class="btn btn-success"
								href="/updateTodo?id=${todo.id}">Update</a>
							<a type="button" class="btn btn-warning"
								href="/deleteTodo?id=${todo.id}">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</div>
<%@ include file="common/footer.jspf"%>