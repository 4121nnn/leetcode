/**
 * // Definition for a _Node.
 * function _Node(val,children) {
 *    this.val = val;
 *    this.children = children;
 * };
 */

/**
 * @param {_Node|null} root
 * @return {number[]}
 */
var postorder = function(root) {
    const res = [];
    const dfs = ((root) => {
        if(root == undefined) return;
        for(let child of root.children) dfs(child);

        res.push(root.val);
    });
    dfs(root);
    return res;
};
