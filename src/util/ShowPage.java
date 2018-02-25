package util;
/*
 * 与某个页面对象相关
 */
public class ShowPage {
 private int startPos;
 private int curPage;
 private int maxPage;
 private int maxRowCount;
 public ShowPage(int totalRecords,int curPage,int rowsPerPage){
	 this.maxRowCount=totalRecords;//执行后关闭，导致下面不能执行！！！
     this.maxPage=(maxRowCount%rowsPerPage==0)?maxRowCount/rowsPerPage:maxRowCount/rowsPerPage+1;
	 if(curPage<1)
	  curPage=1;
	 else if(curPage>maxPage)
	  curPage=maxPage;
	 this.startPos=(curPage-1)*rowsPerPage>0?(curPage-1)*rowsPerPage:0;
	 this.curPage=curPage;
 }

public int getCurPage() {
	return this.curPage;
}
public int getMaxPage() {
	return this.maxPage;
}
public int getStartPos(){
	return this.startPos;
}
}
