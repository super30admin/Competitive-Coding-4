//
//  ValidSudoku.swift
//  DSA-Practice
//
//  Created by Paridhi Malviya on 1/29/26.
//
import Foundation
class ValidSudoku {
    
    
    init() {
        let isValid = isValidSudoku([[".",".",".",".","5",".",".","1","."],[".","4",".","3",".",".",".",".","."],[".",".",".",".",".","3",".",".","1"],["8",".",".",".",".",".",".","2","."],[".",".","2",".","7",".",".",".","."],[".","1","5",".",".",".",".",".","."],[".",".",".",".",".","2",".",".","."],[".","2",".","9",".",".",".",".","."],[".",".","4",".",".",".",".",".","."]]
                                    )
        print("isValid \(isValid)")
        var list = [1, 3, 5]
        inoutCheck(list: &list)
    }
    
    func inoutCheck(list: inout [Int]) {
        list.append(2)
        print("list \(list)")
    }
    
    func isValidSudoku(_ board: [[Character]]) -> Bool {
        let m = board.count
        let n = board[0].count
        let c: Character = "2"
        let str = "Paridhi"
        print("string concatenation with character \(str + String(c))")
        print("char to ascii conversion test *** \(c.asciiValue! - Character("0").asciiValue!) *** isNumber - \(c.isNumber) *** \(Int("2"))")
        //check in all rows horizontally
        for i in 0..<m {
            var rowSet = Set<Character>()
            for j in 0..<n {
                if (board[i][j] == ".") {
                    continue
                }
                if (rowSet.contains(board[i][j])) {
                    return false
                }
                rowSet.insert(board[i][j])
            }
        }

        //check vertically
        for j in 0..<n {
            var columnSet = Set<Character>()
            for i in 0..<m {
                if (board[i][j] == ".") {
                    continue
                }
                if (columnSet.contains(board[i][j])) {
                    return false
                }
                columnSet.insert(board[i][j])
            }
        }

        //check 3*3 boxes
        for ioffset in stride(from: 0, to: m, by: 3) {
            for jOffset in stride(from: 0, to: n, by: 3) {
                var matrixSet = Set<Character>()
                let iCount = 3
                let jCount = 3
                var iCountTracker = 0
                var jCountTracker = 0
                var i = ioffset
                var j = jOffset

                while (iCountTracker < iCount) {
                    while(jCountTracker < jCount) {
                        print("board[i][j] \(board[i][j])")
                        if (board[i][j] == ".") {
                            j += 1
                            jCountTracker += 1
                            continue
                        }
                        if(matrixSet.contains(board[i][j])) {
                            return false
                        }
                        matrixSet.insert(board[i][j])
                        j += 1
                        jCountTracker += 1
                    }
                    j = jOffset
                    jCountTracker = 0
                    i += 1
                    iCountTracker += 1
                }
            }
        }
        return true
    }
 }
