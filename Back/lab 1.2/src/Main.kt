//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val tree = BinaryTree()

    //вставка
    tree.insert(5)
    tree.insert(3)
    tree.insert(1)
    tree.insert(34)
    tree.insert(9)
    tree.insert(7)
    tree.insert(11)

    //обход
    tree.traversal()
    println()

    //удаление + повторный обход
    tree.delete(7)
    tree.traversal()
    println()

    //поиск
    println(tree.search(1)?.value) //элемент будет найден т.к. существует
    println(tree.search(99)) //элемент не будет найден
}


class BinaryTree {
    private var root: TreeNode? = null

    fun insert(value: Int) {
        root = insertRec(root, value)
    }

    fun search(value: Int): TreeNode? {
        return searchRec(root, value)
    }

    fun delete(value: Int) {
        root = deleteRec(root, value)
    }

    fun traversal() {
        traversalRec(root)
    }

    private fun insertRec(root: TreeNode?, value: Int): TreeNode {
        var rootNode = root
        if (rootNode == null) {
            rootNode = TreeNode(value)
            return rootNode
        }

        if (value < rootNode.value) {
            rootNode.left = insertRec(rootNode.left, value)
        } else if (value > rootNode.value) {
            rootNode.right = insertRec(rootNode.right, value)
        }

        return rootNode
    }

    private fun searchRec(root: TreeNode?, value: Int): TreeNode? {
        if (root == null) {
            return null
        }
        if (root.value == value) {
            return root
        }
        return if (value < root.value) {
            searchRec(root.left, value)
        } else {
            searchRec(root.right, value)
        }
    }

    private fun deleteRec(root: TreeNode?, value: Int): TreeNode? {
        val rootNode = root ?: return root

        if (value < rootNode.value) {
            rootNode.left = deleteRec(rootNode.left, value)
        } else if (value > rootNode.value) {
            rootNode.right = deleteRec(rootNode.right, value)
        } else {
            if (rootNode.left == null) {
                return rootNode.right
            } else if (rootNode.right == null) {
                return rootNode.left
            }
            rootNode.value = minValue(rootNode.right!!)
            rootNode.right = deleteRec(rootNode.right, rootNode.value)
        }
        return rootNode
    }

    private fun minValue(node: TreeNode): Int {
        var minv = node.value
        var current = node
        while (current.left != null) {
            minv = current.left!!.value
            current = current.left!!
        }
        return minv
    }

    private fun traversalRec(root: TreeNode?) {
        if (root != null) {
            traversalRec(root.left)
            print("${root.value} ")
            traversalRec(root.right)
        }
    }
}
class TreeNode(var value: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}


