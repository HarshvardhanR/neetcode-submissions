class Solution:
    def carFleet(self, target: int, position: List[int], speed: List[int]) -> int:
        stack = []
        newArray = [[position[i], speed[i]] for i in range(len(position))]

        for pairs in sorted(newArray, key = lambda x: x[0], reverse = True):
            time = ((target - pairs[0]) / pairs[1])
            if not stack or time > stack[-1]:
                stack.append(time)
        
        return len(stack)