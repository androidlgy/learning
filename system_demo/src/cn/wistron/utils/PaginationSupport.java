package cn.wistron.utils;
import java.util.ArrayList;
import java.util.Vector;

/**
 * Struts��ҳ
 * 
 * @author Jrosion
 * @version 1.0
 * @serialData 2006-11-30
 */
public class PaginationSupport {

    // ÿҳ��ʾ�ļ�¼��
    public final static int PAGE_SIZE = 12;

    private int currentPage = 1; // ��ǰҳ

    private int totalPags = 0; // ��ҳ��

    private int totalRows = 0; // ����������

    private int pageStartRow; // ÿҳ��ʼ��

    private int pageEndRow; // ÿҳ������

    private boolean isntHaveNextPage = false; // �Ƿ�����һҳ

    private boolean isntHavePreviousPage = false; // �Ƿ�����һҳ

    private Vector navigationPages = new Vector();

    private ArrayList currentPageDates = new ArrayList(); // ��ǰҳ����

    private String url = ""; // ���ӵ�ַ

    private int nextPage; // ��һҳ

    private int previousPage; // ��һҳ

    private String condition;
    
    /**
     * �����ҳģ��
     * 
     * @param date��ҳ����
     */
    public PaginationSupport(ArrayList paginationDate, int currentPage,
            String url) {

        if (paginationDate != null) {

            // ��ҳ��
            this.totalRows = paginationDate.size();

            // ������ҳ��
            this.totalPags = this.getTotalPages(totalRows);

            // ��ǰҳ
            if (currentPage <= 0) {
                this.currentPage = 1;
            } else if (currentPage > totalPags) {
                this.currentPage = totalPags;
            } else {
                this.currentPage = currentPage;
            }

            // ��һҳ
            this.previousPage = currentPage - 1;

            // ��һҳ
            this.nextPage = currentPage + 1;

            // �ж��Ƿ�����ҳ
            this.isntHaveNextPage = this.getIsntHaveNextPage(currentPage,
                    totalPags);

            // �ж��Ƿ�����ҳ
            if (currentPage > 1) {
                this.isntHavePreviousPage = true;
            } else {
                this.isntHavePreviousPage = false;
            }

            // ����������ʼ��
            int[] row = this.getStartAndEndRow(paginationDate, currentPage,
                    totalPags, totalRows);
            this.pageStartRow = row[0];
            this.pageEndRow = row[1];

            // ��ȡ��ǰҳ��Ҫ��ʾ������
            this.currentPageDates = this.getCurrentPageDate(paginationDate,
                    pageStartRow, pageEndRow);

            this.url = url;

            // ���õ���ҳ
            this.navigationPages = this.getNavigationPages(currentPage,
                    totalPags);
        }
    }

    /**
     * ���ݼ�¼�������й���
     * 
     * @param totalRecord
     * @param currentPage
     * @param url
     */
    public PaginationSupport(int totalRecord, int currentPage, String url) {

        if (totalRecord > 0) {

            // ��ҳ��
            this.totalRows = totalRecord;

            // ������ҳ��
            this.totalPags = this.getTotalPages(totalRows);

            // ��ǰҳ
            if (currentPage <= 0) {
                this.currentPage = 1;
            } else if (currentPage > totalPags) {
                this.currentPage = totalPags;
            } else {
                this.currentPage = currentPage;
            }

            // ��һҳ
            this.previousPage = currentPage - 1;

            // ��һҳ
            this.nextPage = currentPage + 1;

            // �ж��Ƿ�����ҳ
            this.isntHaveNextPage = this.getIsntHaveNextPage(currentPage,
                    totalPags);

            // �ж��Ƿ�����ҳ
            if (currentPage > 1) {
                this.isntHavePreviousPage = true;
            } else {
                this.isntHavePreviousPage = false;
            }

            // ����������ʼ��
            int[] row = this.getStartAndEndRow(currentPage);
            this.pageStartRow = row[0];
            this.pageEndRow = row[1];

            this.url = url;

            // ���õ���ҳ
            this.navigationPages = this.getNavigationPages(currentPage,
                    totalPags);
        }
    }

    /**
     * ������ҳ��
     * 
     * @param totalRows
     * @return
     */
    public int getTotalPages(int totalRows) {

        int result = 1;

        if (totalRows > PAGE_SIZE) {
            if ((totalRows % PAGE_SIZE) == 0) {
                result = totalRows / PAGE_SIZE;
            } else {
                result = totalRows / PAGE_SIZE + 1;
            }
        }

        return result;
    }

    /**
     * �ж��Ƿ�����һҳ
     * 
     * @param currentPages
     * @param totalPages
     * @return
     */
    public boolean getIsntHaveNextPage(int currentPages, int totalPages) {

        boolean result = false;

        if (currentPage >= totalPags) {
            result = false;
        } else {
            result = true;
        }

        return result;
    }

    /**
     * ���ص�ǰҳ��ʾ���ݵ���ʼ��
     * 
     * @param currentPage��ǰҳ
     * @param totalPags��ҳ��
     * @param totalRows������
     * @return
     */
    public int[] getStartAndEndRow(ArrayList paginationDate, int currentPage,
            int totalPags, int totalRows) {

        int[] result = new int[2];

        int startRow = PAGE_SIZE * (currentPage - 1);

        int endRow = 0;

        if (currentPage == totalPags) {
            endRow = totalRows - 1;
        } else {
            endRow = startRow + PAGE_SIZE - 1;
        }

        result[0] = startRow;

        result[1] = endRow;

        return result;

    }

    /**
     * ���ص�ǰҳ��ʾ���ݵ���ʼ��
     * 
     * @param currentPage
     * @return
     */
    public int[] getStartAndEndRow(int currentPage) {

        int[] result = new int[2];

        int startRow = PAGE_SIZE * (currentPage - 1);

        int endRow = PAGE_SIZE;

        result[0] = startRow;

        result[1] = endRow;

        return result;

    }

    /**
     * ��ʼ������ҳ��
     * 
     * @return
     */
    public Vector initNavigationPages(int totalPages) {

        Vector result = new Vector();

        int loop = 11;

        if (totalPages < 10) {
            loop = totalPages + 1;
        }

        for (int i = 1; i < loop; i++) {
            String element = String.valueOf(i).toString();
            result.addElement(element);
        }

        return result;
    }

    /**
     * �õ�����ҳ��
     * 
     * @param currentPages
     * @param totalPages
     * @return
     */
    public Vector getNavigationPages(int currentPages, int totalPages) {

        Vector result = new Vector();

        if (currentPages > totalPages) {
            currentPages = totalPages;
        }

        if (currentPages <= 0) {
            currentPages = 1;
        }

        if (totalPages > 10) {
            int endPages = currentPages + 10;
            int startPages = currentPages;
            if (endPages > totalPages) {
                int morePages = endPages - totalPages;
                startPages = currentPages - morePages + 1;
                endPages = totalPages + 1;
            }

            for (int i = startPages; i < endPages; i++) {
                String element = String.valueOf(i).toString();
                result.addElement(element);
            }

        } else {
            result = this.initNavigationPages(totalPages);
        }

        return result;
    }

    /**
     * �õ���ǰҳ������
     * 
     * @param startRow��ʼ������
     * @param endRow����������
     * @return
     */
    public ArrayList getCurrentPageDate(ArrayList pageDates, int startRow,
            int endRow) {

        if (pageDates == null || pageDates.size() == 0) {
            return null;
        }

        ArrayList result = new ArrayList();

        try {
            for (int i = startRow; i < endRow + 1; i++) {
                result.add(pageDates.get(i));
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

        return result;

    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public boolean isIsntHavePreviousPage() {
        return isntHavePreviousPage;
    }

    public void setIsntHavePreviousPage(boolean isntHavePreviousPage) {
        this.isntHavePreviousPage = isntHavePreviousPage;
    }

    public int getPageEndRow() {
        return pageEndRow;
    }

    public void setPageEndRow(int pageEndRow) {
        this.pageEndRow = pageEndRow;
    }

    public int getPageStartRow() {
        return pageStartRow;
    }

    public void setPageStartRow(int pageStartRow) {
        this.pageStartRow = pageStartRow;
    }

    public int getTotalPags() {
        return totalPags;
    }

    public void setTotalPags(int totalPags) {
        this.totalPags = totalPags;
    }

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    public ArrayList getCurrentPageDates() {
        return currentPageDates;
    }

    public void setCurrentPageDates(ArrayList currentPageDates) {
        this.currentPageDates = currentPageDates;
    }

    public boolean isIsntHaveNextPage() {
        return isntHaveNextPage;
    }

    public void setIsntHaveNextPage(boolean isntHaveNextPage) {
        this.isntHaveNextPage = isntHaveNextPage;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getNextPage() {
        return nextPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    public int getPreviousPage() {
        return previousPage;
    }

    public void setPreviousPage(int previousPage) {
        this.previousPage = previousPage;
    }

    public Vector getNavigationPages() {
        return navigationPages;
    }

    public void setNavigationPages(Vector navigationPages) {
        this.navigationPages = navigationPages;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

}



