# 1113 作業整合檔

姓名：董冠廷  
學號：a114222048

## 一、作業範圍
本檔整合以下作業與紀錄：
- 1016 作業
- 1030 作業
- 1106 作業
- 1113（第七週）作業

## 二、已完成內容

### 1. 1016 作業
- 主要完成檔案：
  - [../1016/starter/RoverMission.java](../1016/starter/RoverMission.java)
- 功能重點：
  - 檢查 explore / scan / charge 的條件
  - 成功時才更新 energy、samples、actionCount
  - 拒絕時不改變狀態
  - 最終輸出成功結果
- AI 使用紀錄：
  - [../1016/AI_USAGE.md](../1016/AI_USAGE.md)

### 2. 1030 作業
- 主要完成檔案：
  - [../1030/starter/MissionLog.java](../1030/starter/MissionLog.java)
- 功能重點：
  - 記錄 command、energy、result 日誌
  - 處理 countCommands、printReplay、printSummary
  - 只計算合法指令範圍 0..3
  - 驗證 {1,1,2} 結果為 SUCCESS
- AI 使用紀錄：
  - [../1030/AI_USAGE.md](../1030/AI_USAGE.md)

### 3. 1106 作業
- 主要完成檔案：
  - [../1106/week06/starter/Mission.java](../1106/week06/starter/Mission.java)
- 功能重點：
  - 完成 Mission.run()
  - 實作 countOk()
  - 實作 lowestEnergy()
  - 保留完整 MissionStep 三欄日誌
  - 返回、成功與拒絕都記錄在日誌中
- AI 使用紀錄：
  - [../1106/week06/AI_USAGE.md](../1106/week06/AI_USAGE.md)

### 4. 1113（第七週）作業
- 主要完成檔案：
  - [week07/starter/Rover.java](week07/starter/Rover.java)
  - [week07/starter/HeavyRover.java](week07/starter/HeavyRover.java)
- 功能重點：
  - 保留父類別狀態，不重複宣告 energy / samples / actionCount
  - 以 protected helper 方法更新狀態
  - drill() 自行檢查停止條件
  - 鑽探後狀態符合 12/3/1/1
- AI 使用紀錄：
  - [week07/AI_USAGE.md](week07/AI_USAGE.md)

## 三、AI 使用紀錄完整內容

### 1016
```md
# 第四週 AI 使用紀錄

姓名／學號：董冠廷 / a114222048

| 欄位 | 記錄 |
|---|---|
| 使用工具 | 已使用 Copilot AI（本次協作）；本週也做了本人編譯與執行驗證 |
| 使用目的與提問摘要 | 檢查探索、掃描、充電的條件與狀態更新；確認拒絕時不改變 energy/samples/actionCount |
| AI 建議與本人處理 | AI 建議我先檢查條件，再更新狀態；我採納這個方向，並依照規格完成程式 |
| 實際驗證結果 | 以 RoverMission 輸入 1,1,2,0 測試；結果為 EXPLORE_OK、EXPLORE_OK、SCAN_OK，最後 SUCCESS；編譯與執行皆成功 |

## 反思
- 這週我最關注的是：拒絕時不得改變狀態，成功時才計次且能量消耗正確。
- 我採納的判斷是：條件先判斷、再更新狀態，否則會讓狀態和結果不一致。
- 本人驗證已透過 javac 與 java 在課堂腳本下重跑確認。
```

### 1030
```md
# 第四週 AI 使用紀錄

姓名／學號：董冠廷 / a114222048

| 欄位 | 記錄 |
|---|---|
| 使用工具 | 已使用 Copilot AI（本次協作）；後續以本人編譯與執行驗證為主 |
| 使用目的與提問摘要 | 確認 ArrayList 日誌如何同步記錄 command、energy、result；檢查 countCommands、printReplay、printSummary 的邏輯 |
| AI 建議與本人處理 | AI 建議我保留範圍檢查，避免無效指令寫入 counts；我採納這個做法，並補上合法判斷 |
| 實際驗證結果 | 以 {1,1,2} 測試，得到 replay 三筆結果；counts[0..3]=[0,2,1,0]；final energy=6, samples=5, actionCount=3 -> SUCCESS；驗證完成 |

## 反思
- 關鍵問題是：日誌可以存無效指令，但統計只算 0..3。
- 我保留此規則，因為這能同時滿足日誌完整性與計數正確性。
- 經過編譯與執行驗證，輸出與規格一致。
```

### 1106
```md
# 第六週 AI 使用紀錄

姓名／學號：董冠廷 / a114222048

| 欄位 | 本人紀錄 |
|---|---|
| 使用工具／方式 | 已使用 Copilot AI（本次協作）；本週也做了本人編譯與執行驗證 |
| 目的與提問摘要 | 檢查 Mission.run、countOk、lowestEnergy 的實作方式；確認返回、成功與拒絕都要記錄在日誌中 |
| 建議與本人處理 | AI 建議我保留完整日誌，不能只存「有用資料」；我採納這個方向，保留 `MissionStep` 三欄並補上合法範圍與空清單判定 |
| 本人實際驗證 | 以 RoverDemo 測試並編譯通過；MissionLog 在 {1,1,2} 下得到 3 步、counts=[0,2,1,0]、lowest energy=6、SUCCESS |

## 我的反思
- 哪一句需求幫我判斷 AI 建議：只保留「有用資料」不等於正確；日誌需完整記錄每一步。
- 只看類別圖還不能證明什麼：不能證明各方法是否真的把狀態與日誌同步，必須編譯執行測試。
```

### 1113
```md
# 第七週 AI 使用紀錄

姓名／學號：董冠廷 / a114222048
工具及來源：已使用 Copilot AI；本週也依照教師規格與本人驗證修正程式。

## 精簡紀錄

| 使用目的與Prompt摘要（註明來源） | 採納／拒絕與理由 | 本人驗證：預期、實際、證據位置 | 最終修改與commit |
|---|---|---|---|
| Copilot AI 協助檢查 HeavyRover 的狀態設計；目的是確認父類別狀態不能重複宣告，且 drill 需自行檢查停止 | 採納：保留父類別狀態，拒絕重複欄位設計；改用 `spendEnergy`、`addSamples`、`countAction` 更新整組狀態 | 預期：鑽探後 energy 12, samples 3, actionCount 1, drillCount 1；實際：程式編譯並執行 `HeavyRoverTry`，輸出全部相符 | 修改 [HeavyRover.java](<C:/Users/m303/Downloads/115_1_Java-main (1)/115_1_Java-main/1113/week07/starter/HeavyRover.java>) 與 [Rover.java](<C:/Users/m303/Downloads/115_1_Java-main (1)/115_1_Java-main/1113/week07/starter/Rover.java>)，以重構方式完成 |

## 反思
- 哪個案例讓我發現「回成功卻沒更新正確狀態」：`drill()` 若重複宣告欄位，狀態更新會落到錯誤物件，導致觀察結果錯誤。
- 我保留或拒絕AI建議的理由：我採納保留父類別狀態、拒絕重複宣告欄位的判斷，因為這能保持狀態一致。
- 我仍無法解釋或尚未完成的部分：目前本週作業已依規格完成，沒有未完成項目。
```

## 四、驗證方式
本人已進行編譯與執行驗證，重點如下：
- 1016：以 RoverMission 測試，最後為 SUCCESS
- 1030：以 {1,1,2} 測試，得到 count 和 replay 正確，最終 SUCCESS
- 1106：以 RoverDemo 測試，MissionLog 在 {1,1,2} 下得到 3 步、counts=[0,2,1,0]、lowest energy=6、SUCCESS
- 1113：以 HeavyRoverTry 執行，輸出與預期狀態一致

## 五、結論
本次作業已依規格完成，並已補齊 AI 使用紀錄與驗證內容。各週檔案皆可在對應目錄中找到完整版本。
