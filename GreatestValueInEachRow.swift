//
//  GreatestValueInEachRow.swift
//  DSA-Practice
//
//  Created by Paridhi Malviya on 2/3/26.
//

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public var val: Int
 *     public var left: TreeNode?
 *     public var right: TreeNode?
 *     public init() { self.val = 0; self.left = nil; self.right = nil; }
 *     public init(_ val: Int) { self.val = val; self.left = nil; self.right = nil; }
 *     public init(_ val: Int, _ left: TreeNode?, _ right: TreeNode?) {
 *         self.val = val
 *         self.left = left
 *         self.right = right
 *     }
 * }
 */

class GreatestValueInEachRow {
    class QueueUsingLinkedList<T> {
       
       private class LinkedListNode<T> {
           var value: T
           var next: LinkedListNode<T>?
           init(value: T) {
               self.value = value
           }
       }

       private var front: LinkedListNode<T>?
       private var rear: LinkedListNode<T>?
       private var count = 0

       func enqueue(value: T) {
           let newNode = LinkedListNode(value: value)
           if (front == nil) {
               front = newNode
               rear = newNode
           } else {
               rear?.next = newNode
               rear = newNode
           }
           count += 1
       }

       func dequeue() -> T? {
           if (front == nil) {
               return nil
           }
           let value = front?.value
           front = front?.next
           if (front == nil) {
               rear = nil
           }
           count -= 1
           return value
       }

       var isEmpty: Bool {
           return count == 0
       }

       var size: Int {
           return count
       }
    }

    /*
     Time complexity -> O(n)
     Space compelxity -> O(n/2) at max in queue, n/2 leaf elements will be present. Hence, O(n)
     */
    func largestValues(_ root: TreeNode?) -> [Int] {
        guard let root = root else {
            return []
        }
        var result = [Int]()
        let queue = QueueUsingLinkedList<TreeNode>()
        queue.enqueue(value: root)
        while(!queue.isEmpty) {
            let size = queue.size
            var maxAtALevel = Int.min
            for _ in 0..<size {
                guard let current = queue.dequeue() else {
                    continue
                }
                maxAtALevel = max(maxAtALevel, current.val)
                if let leftNode = current.left {
                    queue.enqueue(value: leftNode)
                }

                if let rightNode = current.right {
                    queue.enqueue(value: rightNode)
                }
            }

            result.append(maxAtALevel)
        }
        return result
    }
}
