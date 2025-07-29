import java.time.Duration;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.ZoneId;

public class Main4 {
    private String eventName;
    private ZonedDateTime startTime;
    private ZonedDateTime endTime;

    public Main4(String name, ZonedDateTime start, ZonedDateTime end) {
        this.eventName = name;
        this.startTime = start;
        this.endTime = end;
    }
    
    //追加：開始時間をフォーマットする
    public String getFormattedStartTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年M月d日 HH:mm z");
        return startTime.format(formatter);   
    }

    //追加：終了時間をフォーマットする
    public String getFormattedEndTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年M月d日 HH:mm z");
        return endTime.format(formatter);
    }

    public String getEventDuration() {
        Duration duration = Duration.between(startTime, endTime);
        long days = duration.toDays();
        long hours = duration.toHours() % 24;
        return days + "日と" + hours + "時間";
    }

    public String getLocalTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年M月d日 HH:mm z");
        return startTime.format(formatter);
    }

    public String getUtcTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年M月d日 HH:mm z");
        return startTime.withZoneSameInstant(ZoneId.of("UTC")).format(formatter);
    }

    public static void main(String[] args) {
        // ここにテスト用のコードを書いてください
        ZoneId tokyoZone = ZoneId.of("Asia/Tokyo");

        ZonedDateTime start = ZonedDateTime.of(2024, 7, 1, 10, 0, 0, 0,tokyoZone);
        ZonedDateTime end = ZonedDateTime.of(2024, 7, 15, 22, 0, 0, 0, tokyoZone);
        Main4 event1 = new Main4("サマーフェスティバル", start, end);

        System.out.println("イベント: " + event1.eventName);
        System.out.println("開始: " + event1.getFormattedStartTime());
        System.out.println("終了: " + event1.getFormattedEndTime());
        System.out.println("期間: " + event1.getEventDuration());
        System.out.println("現地時間: " + event1.getLocalTime());
        System.out.println("UTC時間: " + event1.getUtcTime());
    }  
}
