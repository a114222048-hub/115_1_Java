# 1106 作業整合檔

姓名：董冠廷  
學號：a114222048

## 一、作業範圍
本檔整合以下作業與紀錄：
- 1016 作業
- 1030 作業
- 1106（第六週）作業
- 1113（第七週）作業

## 二、已完成內容

### 1. 1016 作業
- 主要完成檔案：
  - [1016/starter/RoverMission.java](../1016/starter/RoverMission.java)
- 功能重點：
  - 檢查 explore / scan / charge 的條件
  - 成功時才更新 energy、samples、actionCount
  - 拒絕時不改變狀態
  - 最終輸出成功結果
- AI 使用紀錄：
  - [1016/AI_USAGE.md](../1016/AI_USAGE.md)

### 2. 1030 作業
- 主要完成檔案：
  - [1030/starter/MissionLog.java](../1030/starter/MissionLog.java)
- 功能重點：
  - 記錄 command、energy、result 日誌
  - 處理 countCommands、printReplay、printSummary
  - 只計算合法指令範圍 0..3
  - 驗證 {1,1,2} 結果為 SUCCESS
- AI 使用紀錄：
  - [1030/AI_USAGE.md](../1030/AI_USAGE.md)

### 3. 1106（第六週）作業
- 主要完成檔案：
  - [1106/week06/starter/Mission.java](week06/starter/Mission.java)
- 功能重點：
  - 完成 Mission.run()
  - 實作 countOk()
  - 實作 lowestEnergy()
  - 保留完整 MissionStep 三欄日誌
  - 返回、成功與拒絕都記錄在日誌中
- AI 使用紀錄：
  - [1106/week06/AI_USAGE.md](week06/AI_USAGE.md)

### 4. 1113（第七週）作業
- 主要完成檔案：
  - [1113/week07/starter/Rover.java](../1113/week07/starter/Rover.java)
  - [1113/week07/starter/HeavyRover.java](../1113/week07/starter/HeavyRover.java)
- 功能重點：
  - 保留父類別狀態，不重複宣告 energy / samples / actionCount
  - 以 protected helper 方法更新狀態
  - drill() 自行檢查停止條件
  - 鑽探後狀態符合 12/3/1/1
- AI 使用紀錄：
  - [1113/week07/AI_USAGE.md](../1113/week07/AI_USAGE.md)

## 三、驗證方式
本人已進行編譯與執行驗證，重點如下：
- 1016：以 RoverMission 測試，最後為 SUCCESS
- 1030：以 {1,1,2} 測試，得到 count 和 replay 正確，最終 SUCCESS
- 1106：以 RoverDemo 測試，MissionLog 在 {1,1,2} 下得到 3 步、counts=[0,2,1,0]、lowest energy=6、SUCCESS
- 1113：以 HeavyRoverTry 執行，輸出與預期狀態一致

## 四、結論
本次作業已依規格完成，並已補齊 AI 使用紀錄與驗證內容。各週檔案皆可在對應目錄中找到完整版本。
