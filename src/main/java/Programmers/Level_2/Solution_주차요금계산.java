package Programmers.Level_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Solution_주차요금계산 {
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};

        Map< String, ArrayList<String[]>> recordMap = new HashMap<>();      // recordMap - [ 치번호, {시간, 입/출차 타입} ]
        ArrayList<String> carNumList = new ArrayList<>();

        // 0202, [ {16:00, 입차}, {18:00, 출차} ]
        // 3961, [ {16:00, 입차}, {18:00, 출차}, {23:58, 입차} ] + {23:59, 출차}
        for(String record : records) {
            String[] info = record.split(" ");

            String time = info[0];
            String carNum = info[1];
            String type = info[2];

            if (!recordMap.containsKey(carNum)) {
                recordMap.put(carNum, new ArrayList<>());
                carNumList.add(carNum);
            }

            recordMap.get(carNum).add(new String[] {time, type});
        }

        Collections.sort(carNumList);   // 번호 순으로 정렬

        for(String carNum: carNumList) {
            ArrayList<String[]> recordList = recordMap.get(carNum);

            String lastRecordType = recordList.get(recordList.size() - 1)[1];

            // 어떤 차량이 입차된 후에 출차된 내역이 없다면, 23:59에 출차된 것으로 간주합니다.
            if(lastRecordType.equals("IN")) {
                recordList.add(new String[] {"23:59", "OUT"});
            }
        }

        answer = new int[carNumList.size()];
        Map<String, Integer> feeMap = new HashMap<>();

        int baseMin = fees[0];
        int baseFee = fees[1];
        int unitMin = fees[2];
        int unitFee = fees[3];

        for(String carNum: carNumList) {
            ArrayList<String[]> recordList = recordMap.get(carNum);
            int minute = 0;

            for( String[] record: recordList ) {

                String time = record[0];
                String type = record[1];

                if( type.equals("IN") ) {
                    minute -= toMinutes(time);
                } else {
                    minute += toMinutes(time);
                }
            }

            // 기본 시간 이하?
            if( minute <= baseMin ) {
                feeMap.put(carNum, baseFee);
            } else {
                int exceed = minute - baseMin;

                int totalFee = baseFee;

                // 초과된 시간이 단위 시간으로 나뉘어 진다면,
                if( exceed % unitMin == 0 ) {
                    totalFee += (exceed / unitMin) * unitFee;
                } else {
                    totalFee += ( (exceed / unitMin) + 1 ) * unitFee;
                }

                feeMap.put(carNum, totalFee);
            }
        }

        for(int i = 0; i < answer.length; i++) {
            answer[i] = feeMap.get( carNumList.get(i) );
        }

        return answer;
    }

    static int toMinutes(String time) {
        // "23:58"
        String[] tmp = time.split(":");
        int h = Integer.parseInt(tmp[0]);

        return (h * 60) + Integer.parseInt(tmp[1]);
    }
}
