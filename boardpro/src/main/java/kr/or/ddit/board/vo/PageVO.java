package kr.or.ddit.board.vo;

public class PageVO {
   private int start;         // 시작번호(rownum)
   private int end;         // 끝번호(rownum)
   
   private int startPage;       // 시작페이지번호
   private int endPage;      // 끝페이지번호
   private int totalPage;      // 총페이지개수
   
   private static int perList = 5;      // 로드하는 글 개수  
   private static int perPage = 3;      // 이동 페이지 버튼 개수
   
   public int getStart() {
      return start;
   }
   public void setStart(int start) {
      this.start = start;
   }
   public int getEnd() {
      return end;
   }
   public void setEnd(int end) {
      this.end = end;
   }
   public int getStartPage() {
      return startPage;
   }
   public void setStartPage(int startPage) {
      this.startPage = startPage;
   }
   public int getEndPage() {
      return endPage;
   }
   public void setEndPage(int endPage) {
      this.endPage = endPage;
   }
   public int getTotalPage() {
      return totalPage;
   }
   public void setTotalPage(int totalPage) {
      this.totalPage = totalPage;
   }
   public static int getPerList() {
      return perList;
   }
   public static void setPerList(int perList) {
      PageVO.perList = perList;
   }
   public static int getPerPage() {
      return perPage;
   }
   public static void setPerPage(int perPage) {
      PageVO.perPage = perPage;
   }
   
   
   
}
