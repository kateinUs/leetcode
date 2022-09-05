package leetcode;

import javax.swing.event.ListSelectionEvent;
import java.sql.SQLSyntaxErrorException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author huimin
 * @create 2022-03-08 23:34
 */
public class T811_Subdomain_visit_count {
    HashMap<String, Integer> map;
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> list = new ArrayList<>();
        map = new HashMap<>();
        for(String str: cpdomains){
            String[] splits = str.split(" ");
            int time = Integer.parseInt(splits[0]);
            String domain = splits[1];
            helper(domain, time);
        }
        for(Map.Entry<String, Integer> entry: map.entrySet()){
            list.add(entry.getValue()+ " " +entry.getKey());
        }
        return list;
    }

    private void helper(String domain, int time){
        int prevIdx = 0;
        int curr;
        map.put(domain, map.getOrDefault(domain, 0)+time);
        while((curr =domain.indexOf(".", prevIdx)) != -1){

            prevIdx = curr+1;
            String temp = domain.substring(prevIdx);
            map.put(temp, map.getOrDefault(temp, 0)+time);
        }

    }
}
