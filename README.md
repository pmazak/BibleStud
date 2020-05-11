# BibleStud
Scripture memorization typing game

.-----------------------------------------------  
BIBLE STUD  
.------------------------------------------------

Hey there all you Bible freaks.  Thank you for using my Bible Stud program.  This will help you memorize Scripture while at the same time, fine tuning your typing skills.

But first some important things to get the game working:

.--------------------------------------  
IMPORTANT Format of "verses.txt"  
.--------------------------------------

You ABSOLUTELY MUST FOLLOW THE FORMAT OF THE verses.txt file.  The program reads from the verses.txt file in its current directory.
The format is as follows.  After each line you must hit enter. (Thus you will is always hit &lt;enter> 3 times per Scripture.)  
---line 1---must be the verse,&lt;enter>  
---line 2---must be the text, don't hit enter for new lines, let wordwrap take care of it (like this) so it doesn't matter how long this is.  Hint: You could put anything here, like the books of the bible or an entire book or paragraph and use some keyword for the verse on line 1. USE YOUR IMAGINATION! &lt;enter>  
---line 3---must be the number of the verse that it is, in relation to your other verses.&lt;enter>

So it would look like this:
```
Galations 2:20
I have been crucified with Christ and I no longer live but Christ lives in me
#6#
```

if you had 5 other verses before this one.  If this was your first verse, it would be #1#.
Don't forget to hit &lt;enter> after the last #-sign either so that the program knows when your file ends.

.--------------------------------------  
Program Specs  
.--------------------------------------

- holds up to 999 verses  
- your score is the percent of correct characters you had based on how you have it typed in verses.txt compared with how you type it in the program. (punctuation matters but Capitalization does not.)
- wpm is your words-per-minute

.--------------------------------------  
Instructions  
.--------------------------------------  

1. Select a verse with the buttons. (or it starts with a random one)
``` 
 << = first verse in list in verses.txt
 < = previous verse
 ? = random
 > = next
 >> = last
``` 
2. When you are ready to be timed, simply begin typing in the text field.  When you are done hit &lt;enter>.
3. You will see your % correct as your grade, and your wpm.
4. Hit clear to re-start, or select a different verse.

If you have any questions you can email me at: mazak.5@osu.edu

Hope you like it,
Paul

"I have hidden your word in my heart that I might not sin against you."  -Psalm 119:11
