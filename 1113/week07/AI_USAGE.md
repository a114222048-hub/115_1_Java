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