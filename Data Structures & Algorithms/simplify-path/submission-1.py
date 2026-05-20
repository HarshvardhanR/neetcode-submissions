class Solution:
    def simplifyPath(self, path: str) -> str:
        stringList = path.split("/")
        print(stringList)
        stack = []
        for string in stringList:
            if string=="" or string==".":
                continue
            elif string=="..":
                if stack:
                    stack.pop()
            else:
                stack.append(string)
            
        ans = "/" + "/".join(stack)
        return ans