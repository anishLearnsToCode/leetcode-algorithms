class Solution:
    def licenseKeyFormatting(self, s: str, k: int) -> str:
        s = s.replace('-', '').upper()[::-1]
        return '-'.join(s[i:i + k] for i in range(0, len(s), k))[::-1]
