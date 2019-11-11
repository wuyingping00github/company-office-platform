package company.office.notice;

import com.fasterxml.jackson.annotation.JsonProperty;





    public class Notice {

        //id
        @JsonProperty("auto_id")
        private Long id;

        //标题
        @JsonProperty("title")
        private String title;

        //公告标签
        @JsonProperty("exchange_mc")
        private String exchangeMc;

        //公告发布时间
        @JsonProperty("create_time")
        private String originCreateTime;

        //公告阅读数量
        @JsonProperty("read_count")
        private Integer readCount;


}
