package th.ac.su.cp.storytelling1.db;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.Calendar;

import th.ac.su.cp.storytelling1.model.WordItem;
import th.ac.su.cp.storytelling1.util.AppExecutors;

@Database(entities = {WordItem.class},exportSchema = false, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static final String TAG = "AppDatabase";
    private static final String DB_NAME = "item.db";
    private static AppDatabase sInstance;
    public abstract ItemDao itemDao();
    public static synchronized AppDatabase getInstance(final Context context) {
        if (sInstance == null) {
            sInstance = Room.databaseBuilder(
                    context.getApplicationContext(),
                    AppDatabase.class,
                    DB_NAME
            ).addCallback(new Callback() {
                @Override
                public void onCreate(@NonNull SupportSQLiteDatabase db) {
                    super.onCreate(db);
                    //insertInitialData(context);
                }
            }).build();
        }
        return sInstance;
    }
    private static void insertInitialData(final Context context) {
        AppExecutors executors = new AppExecutors();
        executors.diskIO().execute(new Runnable() {
            @Override
            public void run() { // worker thread
                AppDatabase db = getInstance(context);
                db.itemDao().addItem(
                        new WordItem(
                                0,
                                "นก วัว และแมว",
                                "happy day",
                                "เช้าวันนั้นอากาศหนาวเย็นจัด เสียงลมพัดแรงข้ามท้องทุ่งโล่งกว้าง พัดเอาเปลือกและใบข้าวโพด หมุนเคว้งคว้างไปมา ในขณะที่ลมพัดแรงกระแทกประตูโรงนาดัง..กึงกัง..กึงกัง..นกน้อยตัวหนึ่ง กำลังต่อสู้อย่างสิ้นหวัง ที่จะบินข้ามทุ่งหญ้าเลี้ยงสัตว์ และหมดแรงตกลงใกล้ๆโรงนานั้น\n" +
                                        "ตัวนกน้อย..ตัวเปียกปอนสกปรก แต่จุดมุ่งหมายสำคัญ มันจะต้องข้ามทุ่งหญ้าไปยังรังของมันให้ได้ จึงพยายามบินขึ้นและตกลงมาแล้วหลายครา นกน้อยเหน็บหนาวและหมดแรง…รู้สึกเหมือนกำลังจะขาดใจตาย\n" +
                                        "แม่วัวตัวหนึ่งอยู่ใกล้ๆ จ้องมองที่นกน้อยและเคลื่อนตัว หันก้นของมันมาทางนก ในขณะที่ปากเคี้ยวเอื้องอยู่ ในขณะที่นกกำลังหวาดกลัวอย่างมาก กลัวว่าจะถูกวัวเหยียบ แม่วัวก็ถ่ายมูลกองใหญ่ลงบนตัวนก\n" +
                                        "ในตอนแรก นกน้อยสุดจะ “เซ็ง” หดหู่และสิ้นหวัง มันโกรธแม่วัวอย่างมาก ที่เหมือนซ้ำเติมให้ยิ่งทุกข์ยาก มันพยายามดิ้นรนที่จะให้หลุดออกมาจากกองขี้วัว แต่สักครู่เดียวมันก็เริ่มรู้สึกว่าไม่หนาวอีกต่อไปแล้ว\n" +
                                        "ขี้ที่เพิ่งออกจากตัวแม่วัว มีความร้อนพอจะทำให้ร่างกายของเจ้านกน้อยอบอุ่นขึ้น นกน้อยที่คิดว่าตัวเองกำลังจะตายไปแล้วด้วยสภาพอากาศอันย่ำแย่ กำลังจะรอดชีวิต…ด้วยขี้วัวโสโครก ที่ยังไม่อาจทราบเลยว่าตกลงบนตัวของมันด้วยความตั้งใจของวัวหรือไม่?\n" +
                                        "เจ้านกน้อยรู้สึกเหมือนตายแล้วเกิดใหม่ เมื่อกระแสลมสงบลง มันจึงโผล่หัวออกมาจากกองขี้วัว และร้องเพลงด้วยความลิงโลดใจ แต่…โชคร้ายที่แมวซ่าในโรงนานั้นได้ยินเสียงเพลง จึงคาบเอานกจากกองขี้วัวและกินเสีย\n" +
                                        "\n" +
                                        "ข้อคิดที่ได้จากการอ่าน\n" +
                                        "ผู้ที่นำความยากลำบากมาให้ อาจไม่ใช่เพื่อทำร้ายเรา ส่วนผู้ที่นำเราออกจากความยากลำบากก็อาจไม่ใช่ เพื่อที่จะช่วยเรา\n" +
                                        "และเมื่อได้ลิ้มรสความสุขสมหวัง ก็อย่าด่วนดีใจจนเกินไป")
                        , (new WordItem(
                                0,
                                "คิดแบบผึ้งหรือแมลงวัน",
                                "happy day",
                                "สมมุติว่าเราจับผึ้งจำนวน 6 ตัว ใส่ในขวด และจับแมลงวัน 6 ตัว ใส่ในอีกขวด จากนั้นวางขวดนอนลง โดยหันก้นขวดไปยังหน้าต่างที่มีแสงสว่างกว่า เราจะพบว่า…กลุ่มผึ้งจะพยายามบินออกทางก้นขวด จนกระทั่งมันตายจากการขาดอาหารหรือว่าหมดแรง ในขณะที่แมลงวัน จะบินวนอยู่ในขวดชนไปชนมา แต่ก็จะค่อยๆทยอยบินหาทางออกมาจากขวดได้ จากฝั่งคอขวด ที่อยู่ตรงกันข้ามกับก้นขวดซึ่งหันไปทางหน้าต่าง ทำไมผลการทดลองจึงออกมาแบบนี้….\n" +
                                        "นักวิทยาศาสตร์เชื่อว่า ผึ้งเป็นสัตว์ที่ฉลาด มีองค์ความรู้ พวกมันรู้ว่าหากบินไปในทิศทางที่มีแสงสว่างจะเป็นทางออกจากรัง แต่เมื่อมันต้องมาอยู่ในขวด ซึ่งเป็นสถานการณ์ที่ผึ้งไม่เคยประสบมาก่อน มันก็ยังคงเชื่อในความคิดแบบเดิมๆไม่เปลี่ยนแปลง คือ ต้องบินออกทางแสงสว่างเท่านั้น แต่สำหรับแมลงวัน เป็นสัตว์ที่ไม่มีความคิดเป็นตรรกะอะไร ดังนั้นเมื่อมันถูกจับไว้ในขวด มันจึงบินชนผนังขวดแกะทางไปเรื่อยๆ จนในที่สุดก็พบกับทางออก\n" +
                                        "\n" +
                                        "ข้อคิดที่ได้จากการอ่าน \n" +
                                        "คนฉลาดก็สามารถที่จะพลาดพลั้งล้มเหลวได้ หากมีความรู้แต่ยึดติดกรอบเดิมๆ ในขณะที่ผู้ไม่รู้ หากทำในสิ่งที่แตกต่าง ก็อาจประสบความสำเร็จได้เช่นกัน"
                        )));
            }
        });
    }
}