/**
 * 
 */
boradWriteServer = function() {
	// 서버로 전송 
	$.ajax({
		url: `${myPath}/BoardWrite.do`,
		data: fdata,
		type: 'post',
		success: function(res) {
			// list 출력  (성공시 1페이지 출력)
			listPageServer(1);
		},
		error: function(xhr) {
			alert("condition: " + xhr.status);
		},
		dataType: 'json'
	})
}
listPageServer = function(cpage) {

	vtype = $('#stype option:selected').val();
	vword = $('#sword').val();

	if (vword != null) vword = vword.trim();


	$.ajax({
		url: `${myPath}/BoardList.do`,
		data: {
			"page": cpage,
			"stype": vtype,
			"sword": vword
		},
		type: 'post',
		success: function(res) {
			code = "";
			code += `<div class="container mt-3">
	        <h2>Accordion Example</h2>
	        <div id="accordion">`
			$.each(res.datas, function(i, v) {

				content = v.content;

				content = content.replace(/\n/g, "<br>");

				code += `<div class="card">
	        <div class="card-header">
	       <a class="btn" data-bs-toggle="collapse" href="#collapse${v.num}">
	         ${v.subject}
	       </a>
	     </div>
	     <div id="collapse${v.num}" class="collapse" data-bs-parent="#accordion">
	       <div class="card-body">
	         <div class="p12">
	            <p class="p1">
	               작성자: <span class="wr">${v.writer}</span> &nbsp;&nbsp;&nbsp; 
	               이메일: <span class="ma">${v.mail}</span> &nbsp;&nbsp;&nbsp; 
	               조회수: <span class="hit">${v.hit}</span> &nbsp;&nbsp;&nbsp; 
	               날짜: <span class="da">${v.wdate}</span>
	            </p>
	            <p class="p2">
	               <input type="button" idx="${v.num}" value="수정" name="modify" class="action">
	               <input type="button" idx="${v.num}" value="삭제" name="delete" class="action">
	            </p>
	         </div>
	         <p class="p3">${content}</p>
	         <p class="p4">
	               <textarea rows="" cols="50"></textarea>
	               <input type="button" idx="${v.num}" value="등록" name="reply" class="action">
	         </p>
	       </div>
	     </div>
	   </div>`
			}) // $.each

			code += `</div></div>`

			$('#result').html(code);

			// 페이지 처리 
			pager = "";

			// 이전 
			pager += `<ul class="pagination">`;
			if (res.sp > 1) {
				pager += `<li class="page-item"><a id="prev" class="page-link" href="#">Previous</a></li>`;
			}
			// 페이지 번호
			for (i = res.sp; i <= res.ep; i++) {
				if (i == currentPage) {
					pager += `<li class="page-item active"><a class="page-link pageno" href="#">${i}</a></li>`;

				} else {
					pager += `<li class="page-item"><a class="page-link pageno" href="#">${i}</a></li>`;
				}
			}
			// 다음
			if (res.ep < res.tp) {
				pager += `<li class="page-item"><a id="next" class="page-link" href="#">Next</a></li>`;
			}
			pager += `</ul>`;

			$('#pageList').html(pager);
		}, //success
		error: function(xhr) {
			alert("상태: " + xhr.status)
		},
		dataType: 'json'
	})

}