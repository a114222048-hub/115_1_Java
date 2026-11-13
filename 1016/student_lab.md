# 第四週學生實作：火星探測車任務日誌

姓名：待填　學號：待填　實際上課日期：待填　實際 JDK：待填

另存為當日 LAB_REPORT.md。A–H 必做，最後的延伸選做。先預測再執行；教師示範觀察與本人實測分開。作業完整需求見 [assignment.md](assignment.md)。

## A｜取回與先備診斷（10 分鐘）

1. 無 repo 時 clone，有副本先保存再 Fetch/Pull；在 115_1_Java/YYYY_MM_DD 建 java-04/src。
2. 放五個核心 examples 與 starter/MissionLog.java，勿放 teacher 同名類別；日期下放本報告及 AI_USAGE。
3. 執行 java -version、javac -version，寫下完整版本：JDK 17.0.12 / javac 17.0.12（本人實測）。不限定特定 JDK 版本。
4. 在 java-04 編譯 `javac -encoding UTF-8 -d out src/*.java`；成功後跑 MissionLog。此時能跑任務但日誌與摘要未完成，是預期起始狀態。

診斷：第三週 {1,1,2} 的最終能源/樣本/成功行動次數：6/5/3。{2,1,1} 是否相同：否，因為路線不同，最終狀態會不同。只有最終三個數字，能否分辨路線：不能；因為不同路線可能產生相同終值。

## B｜固定資料：陣列與計數（30 分鐘）

教科書 §7.2–7.4、§7.7。先讀 ArrayBasics，再執行。

| 項目 | 預測 | 本人實際結果 |
|---|---|---|
| script.length | 3 | 3 |
| new int[4] 內容 | [0, 0, 0, 0] | [0, 0, 0, 0] |
| new String[2] 內容 | [null, null] | [null, null] |
| 逐步指令輸出 | 1, 1, 2 | 1, 1, 2 |
| 指令數值加總（不是行動數） | 4 | 4 |

1. length 是欄位，不加括號；陣列合法索引範圍是：0 到 length - 1。
2. 在副本取消越界行註解，編譯並執行，記錯誤種類與索引：ArrayIndexOutOfBoundsException，索引為 3（當 script.length = 3 時，合法最大索引是 2）。隨即恢復。
3. 執行 CommandCounter：腳本 {3,9,0,1,1,-1}，預測 counts：[1, 2, 0, 1]；實際：[1, 2, 0, 1]。9 和 -1 為何不得當索引：因為索引必須在 0..counts.length-1 的範圍內，9 和 -1 都不合法。
4. 把 CommandCounter 的固定資料改為 {0,2,2,3}，預測：[1, 0, 2, 1]；實際：[1, 0, 2, 1]；恢復原示範。
5. 一般 for 適合需要步號/索引；加強版 for 適合只讀每筆值。若在 `for (int command : script)` 內寫 command=0，是否改掉 script 的元素：不會。用副本檢查：確實沒有改動原陣列元素。

## C｜參考與方法（10 分鐘）

教科書 §7.8–7.9。ArrayReference 的兩個變數先指向同一陣列；畫箭頭或用文字描述。

| 時間點 | 預測 energy 內容 | 本人實際 |
|---|---|---|
| alias[0]=19 後 | [19, 14, 8] | [19, 14, 8] |
| changeFirst 後 | [18, 14, 8] | [18, 14, 8] |
| replaceLocal 內的新陣列 | [20, 20, 20] | [20, 20, 20] |
| 回到 main 後 | [18, 14, 8] | [18, 14, 8] |
| == 與 Arrays.equals 的兩個結果 | == false，equals true | == false，equals true |

Java 傳值；陣列參數取得的是：陣列物件的參考（reference copy）。為何修改元素看得見，重新指定參數卻不改呼叫端：因為修改元素改的是同一個陣列物件；但 `values = new int[] {...}` 只是把方法內的 local reference 改向新陣列，不會改變呼叫端原本的變數。

## D｜筆數會增加：ArrayList（15 分鐘）

教科書 §7.16、§16.3–16.4。C# List<T> 若尚未學過，以右欄 Java 為準。

先分清腳本與日誌：{1,1,1,1}有四筆預定指令，但從20/0出發第三次探索就達標，因此只記三筆。陣列可搭配有效筆數保存；ArrayList每記錄一步就add，size()直接取得已存筆數，本週用它練習逐筆記錄。

| 操作 | C# List<int> | Java ArrayList<Integer> |
|---|---|---|
| 筆數 | Count | size() |
| 讀第 i 筆 | list[i] | get(i) |
| 改第 i 筆 | list[i]=x | set(i,x) |
| 尾端新增 | Add(x) | add(x) |
| 刪索引 | RemoveAt(i) | remove(i) |

執行 ListBasics：

| 項目 | 預測 | 本人實際 |
|---|---|---|
| 原清單/size/first | [1, 1, 2], size=3, first=1 | [1, 1, 2], size=3, first=1 |
| set(1,3) 後 | [1, 3, 2] | [1, 3, 2] |
| remove(0) 後 | [3, 2] | [3, 2] |
| remove(Integer.valueOf(3)) 後 | [2] | [2] |
| isEmpty() | false | false |

int 放入清單會裝箱，讀成 int 會拆箱；ArrayList<int> 為何不能編譯：因為 Java 泛型參數必須是參考型別，`int` 不能直接當作 `ArrayList<int>` 的型別，必須改成 `ArrayList<Integer>`。可以在副本重現編譯訊息，但必須恢復可編譯版本。remove 的兩種用途只需能分辨，不要求說明完整過載規則。

## E｜新增、回放、計數（35 分鐘）

教師提供第三週的行動規則、迴圈與方法骨架，先只完成 TODO **2→3→1**。每完成一項就編譯。F1 再完成 4、5。

- TODO 2：每步執行後把 command、energy、result 同時 add；拒絕、無效與返回也要保存。
- TODO 3：同一索引讀三條清單，格式 `step 1: command=1, result=OK, energy=14`。
- TODO 1：建立 int[4]，計算日誌中的 0–3 指令；越界指令不進 counts。

{3,9,0} 的逐步追蹤：

| 步 | 指令 | 預測結果/執行後能源 | 本人實際結果/能源 |
|---|---|---|---|
| 1 | 3 | OK，能源=20 | OK，能源=20 |
| 2 | 9 | UNKNOWN_COMMAND，能源=20 | UNKNOWN_COMMAND，能源=20 |
| 3 | 0 | RETURN，能源=20 | RETURN，能源=20 |

此時 commandLog/energyLog/resultLog 各有幾筆：3 筆。actionCount 是幾次：1 次。差異原因：只有成功的步驟計入 actionCount；拒絕與返回不算成功行動。

完成 F1 的摘要後，補齊六條本人測試。每列修改 main 固定腳本並重新編譯，初始值 20/0；將**完整輸出**貼在本表下方，包含回放、counts、摘要、最低能源、最終狀態與 battery。

| script | 預期狀態/結果 | 本人實際狀態/結果 | counts、摘要、每筆回放均相符？ |
|---|---|---|---|
| {0} | 20/0/0 RETURNED | 20/0/0 RETURNED | 是 |
| {1,1,2} | 6/5/3 SUCCESS | 6/5/3 SUCCESS | 是 |
| {2,2,2,2,2} | 10/5/5 SUCCESS | 10/5/5 SUCCESS | 是 |
| {3,9,0} | 20/0/0 RETURNED | 20/0/0 RETURNED | 是 |
| {1,1,1,1} | 2/6/3 SUCCESS | 2/6/3 SUCCESS | 是 |
| {2,1} | 12/3/2 UNFINISHED | 12/3/2 UNFINISHED | 是 |

完整輸出：

```text
=== replay ===
step 1: command=1, result=OK, energy=14
step 2: command=1, result=OK, energy=8
step 3: command=2, result=OK, energy=6
counts[0..3]=[0, 2, 1, 0]
summary: steps=3, ok=3, rejected=0, ignored=0
lowest energy=6
final energy=6, samples=5, actionCount=3 -> SUCCESS
battery=30.0
```

繳交前恢復 {1,1,2}。課堂沒完成的路線，課後補齊本人實測。

## F｜摘要、需求與反例（30 分鐘）

### F1 Collections 與 TODO 4–5（10 分鐘）

先執行 CollectionsDemo，預測 min/max/frequency：min=6, max=20, frequency(8)=1；實際相符。排序後 original：[14, 8, 20, 6]；sorted：[6, 8, 14, 20]。為何不能只排序 energyLog 來做回放：因為排序會改變原始時間順序，回放需要照執行順序逐步顯示，不是依能源大小。

- TODO 4：ok=frequency(resultLog,"OK")，returned=frequency(resultLog,"RETURN")；steps=size，rejected=steps-ok-returned，ignored=scriptLength-steps。
- TODO 5：isEmpty 為 true 時印 `lowest energy=N/A`；否則才用 min。
- 最低能源只看每步結束後的 energyLog，不含初始能源。

教師使用 FixedScriptMission 示範以下案例；學生填預測與觀察，不需另寫入口。未觀察請註明待補；自己另跑者再註明「本人複驗」。

| 初始 energy/samples；script | 預測結果/日誌筆數/最低能源 | 教師實際示範觀察 |
|---|---|---|
| 5/0；{1,3,0} | 5/0/0 RETURNED，日誌 2 筆，最低能源 5 | 觀察到 5/0/0 RETURNED，日誌筆數 2，最低能源 5 |
| 2/4；{2} | 2/4/0 未完成，日誌 1 筆，最低能源 2 | 觀察到 2/4/0 未完成，日誌 1 筆，最低能源 2 |
| 0/0；{3,1} | 0/0/0 EXHAUSTED，日誌 1 筆，最低能源 0 | 觀察到 0/0/0 EXHAUSTED，日誌 1 筆，最低能源 0 |
| 20/5；{1} | 20/5/0 SUCCESS，日誌 0 筆，最低能源 不適用 | 觀察到 20/5/0 SUCCESS，任務已達標，不再執行 |
| 20/0；{} | 20/0/0 UNFINISHED，日誌 0 筆，最低能源 N/A | 觀察到 20/0/0 UNFINISHED，無紀錄 |

### F2 Prompt 設計（10 分鐘）

目的：把剛才實作的日誌轉成清楚的資料需求，作為判斷 AI 建議是否適合的依據。

先填下表，再自行組成可直接提問的一段 Prompt。接著用這份需求判讀下方兩個模擬建議。沿用原本的 MissionLog，本段產出為一段 Prompt 與兩項判斷；真實 AI 服務可選。

| 要交代的需求 | 本人的內容 |
|---|---|
| 欄位與型態 | command: int，energy: int，result: String；每筆日誌為 MissionStep；日誌可用 ArrayList<MissionStep> |
| 筆數是否事先固定 | 不固定，逐步加入；固定腳本有上限，但互動任務與日誌仍持續增長 |
| 是否保留順序 | 是，保留執行順序，回放必須依記錄順序列印 |
| 是否容許重複 | 是，指令可重複，探索、掃描與充電都可以重複出現 |
| 新增、回放、計數與最低值等操作 | add、get、size、countCommands、printReplay、printSummary、lowestEnergy |
| 允許的技術與驗證案例 | 可用 ArrayList、陣列與 Collections；驗證 {1,1,2}、{3,9,0}、{0}、{2,1} |

完整 Prompt：

```
請幫我設計一個火星探測車任務日誌，需保存每一步的指令、執行後能源與結果字串，並保留執行順序。每次執行一個指令，若成功、拒絕或返回都要記錄到 ArrayList 中；無效指令也要保留在日誌，但不能計入指令統計。需要支援：逐步追加、回放、統計 0~3 指令各出現幾次、計算成功/拒絕/返回筆數、最低能源、最終狀態判定。請保留順序、允許重複命令，並在 {1,1,2}、{3,9,0}、{0}、{2,1} 等案例驗證輸出。
```

判讀下列**模擬建議**：

| 建議 | 採納/拒絕/補充條件與理由 |
|---|---|
| 歷程最多用 int[100] 保存就好 | 拒絕：固定腳本有上限，但任務日誌通常會逐步增加，且未來可能接收互動輸入；若超過 100 需明確處理，不可硬限。 |
| ArrayList 保存日誌，HashSet 保存指令，避免重複 | 部分採納：日誌應用 ArrayList 以保留順序；但指令不一定要去重，因為任務可重複探索且順序也有意義，所以 HashSet 不適合作為主日誌結構。 |

不要求實作 HashSet；依 List/Set/Map 的概觀判讀即可。使用固定腳本時筆數有上限，但日誌仍逐步成長且將來可能回到互動輸入；不能一概宣稱陣列無法記錄歷程。

### F3 模擬 AI 除錯二選一（10 分鐘）

先 commit 人工版，在副本測試，最後恢復正確版。

1. 刪掉 countCommands 的範圍檢查，理由「指令只有 0–3」；反例可用 {3,9,0}。
2. 把 printReplay 的 `< commandLog.size()` 改成 `<= commandLog.size()`，理由「最後一步也要印」；反例可用 {0}。

| 證據 | 本人紀錄 |
|---|---|
| 選哪種建議與反例；預期行為 | 選擇第一種：用 {3,9,0} 反例，因為 `9` 無效但仍要記錄，不能越界；預期 counts 不含 9，仍保留日誌。 |
| 修改前實際結果/錯誤訊息 | 修正前若去掉範圍檢查，則 `counts[9]` 會造成 ArrayIndexOutOfBoundsException。 |
| 最小修正與採納/拒絕理由 | 最小修正是補回 `if (command >= 0 && command < counts.length)`，因為日誌可記無效指令，但統計只計 0–3。 |
| 修正後反例實際結果 | 修正後 {3,9,0} 不再越界，counts = [1,0,0,1]，結果 RETURNED。 |
| 修正後 {1,1,2} | 修正後 {1,1,2} 成功得到 6/5/3 SUCCESS，和 E 的輸出一致。 |
| 修正後 {3,9,0} | 修正後 {3,9,0} 得到 20/0/0 RETURNED，counts=[1,0,0,1]。 |

若時間不足，課後補測；AI_USAGE 的驗證欄可引用本表，不必重抄。

## G｜課末檢核與第五週入口（5 分鐘）

1. length、size()、length() 分別用於什麼：`length` 用在陣列；`size()` 用在 ArrayList / 集合；`length()` 用在 String。
2. 三筆日誌是否必定代表三次成功行動：不一定；日誌也可能是成功、拒絕或返回，只要是三筆執行紀錄就算三步。
3. 三條清單漏加其中一筆會發生什麼：同一索引讀取時會導致資訊錯位，例如 command 與 result 不屬於同一步，回放與摘要會失真。
4. 為何固定四種指令計數用陣列，逐步增加的日誌用 ArrayList：因為指令種類固定且只有 0~3，可直接用長度 4 的陣列；日誌筆數會隨執行逐步增長，適合 ArrayList 動態儲存。
5. 下週如何把同一步三個欄位整合在一起：可用自定義類別或 record，例如 `MissionStep { int command; int energy; String result; }`，每一步一個物件。

## H｜保存、推送與取回（15 分鐘）

- 恢復預設腳本，重新編譯執行；LAB_REPORT、AI_USAGE、專案 README 完成。
- commit、push，核對 GitHub main 最新 commit 與來源檔。只 commit 或 Changes 空白不代表已推送。
- 在另一位置 clone，同一專案重新編譯並跑 MissionLog；課堂不足可課後完成。

GitHub repo/作業目錄：本機資料夾 `c:\Users\m303\Downloads\115_1_Java-main (1)\115_1_Java-main`；最終 commit：依實際 commit 顯示，需在 GitHub 上核對最新 commit。 
本人新副本 JDK/編譯/預設輸出：JDK 17.0.12，編譯命令 `javac -encoding UTF-8 -d out src/*.java`，預設輸出為 `MissionLog` 以 {1,1,2} 執行後的 `SUCCESS`。 
推送若失敗先請教師協助，仍無法推送時保存完整 repo 至不會還原的位置，確認可讀並後續補推。

## 課後選做

- ScriptArgs：執行 `java -cp out ScriptArgs 3 9 0`，說明 args 的元素型態；非整數例外不列必做。
- 新增自訂路線，比較達標時剩餘能源與成功行動數，不要求最佳化演算法。
- 只顯示成功步驟時，以 if 跳過顯示；保留原日誌，驗證 counts 和摘要仍相同。
