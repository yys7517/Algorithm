package Programmers.Level_1;

public class Solution_붕대감기 {
    // t초 동안 붕대 감기
    // 1초마다 x만큼 체력회복
    // 연속으로 붕대를 감는데 성공하면 y만큼의 체력을 추가로 회복

    // 기술을 쓰는 도중 공격 당하면 기술이 취소
    // 공격을 당하는 순간에는 체력 회복 x
    // 기술이 끝나거나, 취소되면, 즉시 붕대감기
    // 현재 체력이 0이하가 됨녀 사망

    public int solution(int[] bandage, int health, int[][] attacks) {
        int currentHealth = health;    // 초기에 최대체력을 갖고 시작

        // bandage - [ t, x, y ] [ 붕대 감는 시간, 초당 회복량, 추가 회복량 ]
        int castingTime = bandage[0];
        int healPerSec = bandage[1];
        int bonusHeal = bandage[2];

        // health - 최대체력
        // attacks - 몬스터의 공격 시간과 피해량

        int time = 0;

        for(int[] attack: attacks) {
            int attackTime = attack[0];
            int damage = attack[1];

            int continuos = 0;
            time++;

            while(time < attackTime) {
                continuos++;

                // 체력 회복 (최대 체력을 초과해서 회복할 수 없다.)
                currentHealth = Math.min(health, currentHealth + healPerSec);

                // 연속 회복 성공
                if( continuos == castingTime ) {
                    currentHealth = Math.min(health, currentHealth + bonusHeal);

                    continuos = 0;  // 연속 성공 후, 연속 시간 초기화
                }

                // System.out.println("시간 : " + time);
                // System.out.println("현재 체력 : " + answer);

                time++;
            }

            // System.out.println("공격받음");
            currentHealth -= damage;
            // System.out.println("시간 : " + time);
            // System.out.println("현재 체력 : " + answer);

            // 만약 몬스터의 공격을 받고 캐릭터의 체력이 0 이하가 되어 죽는다면 -1을 return 해주세요.
            if( currentHealth <= 0 ) return -1;
        }


        // 남은 체력을 return
        return currentHealth;
    }
}
