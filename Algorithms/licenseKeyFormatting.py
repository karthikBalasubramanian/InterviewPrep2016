class Solution(object):
    def licenseKeyFormatting(self, S, K):
        """
        :type S: str
        :type K: int
        :rtype: str
        """
        if(len(S)<K):
            return S
        else:
            S = S.replace('-','')
            S = S.upper()
            length = len(S)
            if(length%K==0):
                return "-".join([S[i:i+K] for i in range(0,length,K)])
            else:
                rest = S[:(length%K)]
                even =S[(length%K):]
                return rest+"-"+"-".join([even[i:i+K] for i in range(0,length,K) if even[i:i+K]!="" ])


sol = Solution()
print sol.licenseKeyFormatting("2-4A0r7-4k",4)