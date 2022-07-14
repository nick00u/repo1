package com.lagou.common.elasticsearch;

import com.google.gson.Gson;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.SearchResultMapper;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.aggregation.impl.AggregatedPageImpl;

import java.util.ArrayList;
import java.util.Map;

public class ESSearchResultMapper implements SearchResultMapper {
    @Override
    public <T> AggregatedPage<T> mapResults(SearchResponse searchResponse, Class<T> aClass, Pageable pageable) {

        // 获得总记录数
        long totalHits = searchResponse.getHits().getTotalHits();
        // 记录列表
        ArrayList<T> list = new ArrayList<>();

        // 获取原始的搜索结果
        SearchHits hits = searchResponse.getHits();
        for (SearchHit hit : hits) {
            if (hits.getHits().length <= 0) return null;

            // 获取_source属性中的所有数据
            Map<String, Object> map = hit.getSourceAsMap();
            // 获取高亮的字段
            Map<String, HighlightField> highlightFields = hit.getHighlightFields();
            // 每个高亮字段都需要进行设置
            for (Map.Entry<String, HighlightField> highlightFieldEntry : highlightFields.entrySet()) {
                String key = highlightFieldEntry.getKey(); // key：高亮字段
                HighlightField value = highlightFieldEntry.getValue();  // value：高亮后的效果
                // 将高亮字段和文本效果放入map中（替换原来key的value）
                map.put(key, value.getFragments()[0].toString());
            }
            // 将map转换为对象
            Gson gson = new Gson();
            // map-->jsonString-->对象
            T t = gson.fromJson(gson.toJson(map), aClass);
            list.add(t);
        }

        return new AggregatedPageImpl<>(list, pageable, totalHits);
    }
}
