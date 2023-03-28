# https://leetcode.com/problems/minimum-cost-for-tickets/description/
# T: O(N) where N is the last day of travel
# S: O(N) where N is the last day of travel

class Solution:
    def mincostTickets(self, days, costs):
        # Create a list of size days[-1] + 1 and initialize it with 0's
        dp = [0] * (days[-1] + 1)
        
        # Create a set of travel days
        travel_days = set(days)
        
        # Iterate over the range of 1 to len(dp) with a step of 1
        for i in range(1, len(dp)):
            # If the current day is not in the set of travel days
            if i not in travel_days:
                # Set its cost to the cost of traveling on the previous day
                dp[i] = dp[i - 1]
            else:
                # Calculate the minimum cost for traveling on that day
                dp[i] = min(dp[max(0, i - 1)] + costs[0],
                            dp[max(0, i - 7)] + costs[1],
                            dp[max(0, i - 30)] + costs[2])
        
        # Return the last element of this list which will be the minimum cost of travel for all days
        return dp[-1]
