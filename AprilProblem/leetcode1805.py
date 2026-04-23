class Solution:
    def numDifferentIntegers(self, word):
        unique = set()
        num = ""

        for ch in word:
            if ch.isdigit():
                num += ch
            else:
                if num:
                    num = num.lstrip('0') or '0'
                    unique.add(num)
                    num = ""

        if num:
            num = num.lstrip('0') or '0'
            unique.add(num)

        return len(unique)
