---
layout: post
title:  "Things to change (eventually)"
date:   2020-12-14 10:00:00 -0600
categories: teaching
---

I historically have hated the idea of "there's always room for improvement" and it's only recently that I've thought carefully about why that is. I love the principles of Growth Mindset and have found them supremely helpful on my teaching journey, so it seemed weird that at the same time my skin crawled whenever someone talked about always wanting to improve. I eventually realized that it was perfectionism still sneaking its way in since if there was room for improvement, it wasn't perfect, and it was unacceptable to ever offer a less than perfect class so I had to work myself to the bone to reach perfection immediately and then never need to improve again. If I could never reach perfection despite working myself to the bone, I would have to always work myself to the bone and damn is that a depressing thought. 

Anyway, now that I've identified perfectionism sneaking in again, I can fight it and aim for balance of trying to improve a few things each time I teach a class. That phrase 'a few' is quite important since I can't improve everything at once and so by necessity, some things will have to be imperfect for now. Deciding which few things to improve this coming term is the point of this post, where I will attempt to list out the things popping around my brain for my class CS 201 Data Structures and weigh the pros and cons of focusing on that thing versus others. (In the spirit of avoiding perfectionism, there will be typos, enjoy!)

The things are:
* Switch from Piazza to Moodle
* Introduce beginning of class formative polls/quizzes
* Reweight rubrics of the homeworks
* Develop test suites for the homework and/or labs
* Develop polished solutions for the labs
* Embrace spec/mastery grading scheme
* Change some of the homeworks to require inheritance
* Adjust the requirements of the homeworks
* Make more videos instead of readings
* Make reference sheets to go along with videos or readings

Yeah, this is good confirmation for why I can't do everything I want to this coming term....

## Switch from Piazza to Moodle
This is a necessity really since Piazza has shifted to a paid and/or an advertising model and I'm just getting an icky feeling about continuing to use it given how they may or may not use my students' data. Since I use Moodle as my LMS now, I will try out their forums for anonymous question and answer. I know a lot of colleagues that use Slack, but I like the anonymous option for an intro class (well, second class, but close enough). 

There may be other options (Campuswire is the one I've heard of in addition to Slack), but I really don't want to tackle a whole new tool and add it to students' burden if a built-in one is good enough.

## Introduce beginning of class formative polls/quizzes
I decided on this being my preferred way of [capturing students' questions in a flipped classroom](/teaching/2020/12/01/flipped-classrooms). It shouldn't be too hard since I had daily quizzes last term that I think I will move to being here instead. There is still the issue of it taking potentially a lot of a short class period, but I was recently reminded that students are expected to do a whopping 15 hours of work for my class a week. Only 3.5 hours are in class, I expect an hour max on the reading or video for each day, so they have 8.5 hours left for the homework for the week and to finish their lab activities. (This does mean that they have to work on school 45 hours a week if they take three classes, which is rather problematic....)

This will be a small addition of work on my part that I think will be a large gain for students in that they will get more questions answered because they will ask more questions. I will also be putting homework questions on these polls to motivate them to start reading the homework assignment early!

## Reweight rubrics of the homeworks
As is expected the first time you teach a course, I realized after the fact that some of the rubrics I came up with for homework assignments allowed students to get near full credit without doing the things that really mattered. At first I was thinking of trying out a tiered rubric for each homework assignment ([example tiered rubric here](/classes/201-w21/example-tiered-rubric)), but discussion with colleagues firmed up the worry that a student would not realize they messed up an early tier and then not get credit for all the work on a later tier, which would lead to, well, tears. Without allowing for unlimited corrections, I don't see the tiers working. Instead, I could just reweight the rubrics so that the core concepts are worth 70% of the points, so if a student messes up the core concept, they still get credit for the other things they did, but they can't get an A on that assignment. Obviously the goal would be to not run into the situation of a student messing up the core concept, and I hope that more weight being on that will motivate them to ask questions instead of just push through. 

This would require a bit of work to redo the rubrics but not a ton. The downsides from the student-perspective of 70% of points going to a small set of core concepts is that if a student isn't getting that concept, they won't be able to get as high of a grade, but if a C means "able to go on to the next class", that means they really do need to get a handle on those core concepts. I think this is a worthwhile adjustment to make this coming term and captures what I really wanted from the tiered rubric without as much of the giant potential downside.

## Develop test suites for the homework and/or labs

It is always frustrating when a student submits code that they think works perfectly but in fact has a major logical error. Test suites would be handy for grading (though not everything can be checked with a test suite) and I generally follow the principle of transparency where if I have a test suite for my graders to grade with, I might as well give it to my students so they know exactly how they will be graded. 

There are several downsides to providing test suites however. One is just the time involved in making them, which isn't insignificant, though also shouldn't be too much more than is already spent when grading the assignments. Since we are theoretically using Repl.it, I might even be able to have them run automatically, what a concept. 

Another, however, is pedagogical. As soon as you give students a test suite, they stop thinking about how they know if their code is working correctly and start just trying things and seeing if they pass the test suite. At a 200 level, I think that might be okay. Learning how to test their code is not a learning objective of the course, though you might make a very good argument that it is a part of developing medium-sized projects and problem-solving in general. If I get fancy and have Repl.it run the tests, I could report to students if they pass the tests, but nothing more about the tests, so they would still have to think about how their code is working. 

I'm thinking of a compromise where I provide a partial test suite, and clearly state that it is only partial, so that errors on the core concepts can be caught and (hopefully) corrected, but to get all the points on a homework, they have to test their code themselves. This has both pedagogical benefits and means less work in test development for me! 

I think I'll aim for partial test suites on the homework, of which there are only 8, rather than the labs, of which there are 25+....

## Develop polished solutions for the labs

A request of some students last term was solutions for the labs (of which, remember, there are 25+). I didn't want to hand out rough solutions from both a pedagogical perspective and, honestly, pride. If I'm going to give students solutions, I want to be sure that they are reasonably done and well commented and styled. Students will obviously look to those solutions as examples as they code, so I would want them to be damn good examples. 

This would be a pretty serious time commitment if I were to do all of the labs. Some of them I already have a rough solution to that I would just need to polish, but some of them I was much more rushed when developing and so don't actually have complete solutions at the moment. It would doubtless be good to have polished solutions that I was confident in. I also have pretty poor memory and so do like to redo the labs each term within a week of guiding students through them so that I actually remember how they are to be solved and focusing on developing more polished solutions could be a good use of that time.

## Embrace spec/mastery grading scheme

This is the dream, but definitely not feasible this term. Starting on the test suites will be a step in this direction since unlimited corrections/redos is a central tenant to this scheme and I don't have the grading time for that without autograding. A lot of my other goals are trying to tackle small things that will make this dream feasible in the future.

There are certainly pros and cons to mastery grading, a big one being that a difference in grades often gets turned into a difference in time investment on the students' part which can be argued as good or bad. Given my goal is to assist every student in meeting their own goals in the course, I'm all right with that trade off. Given it often leads to higher grades because students can work at something until they master it and get that B or A they are aiming for, this is slightly risky depending on expectations of the institution. Fortunately for me, it sounds like my institution is pretty okay with high grades, or at least no one will come knocking on your door.


## Change some of the homeworks to require inheritance

There is clearly not an order to these ideas since we've swung from huge undertaking back to small, reasonable task. Sorry, not sorry.

I settled on a final project that had to incorporate inheritance as a central mechanism since that is a pretty core concept of object-oriented programming in Java and a thing that differentiates it from other styles of programming. However I realized that none of the homework after HW2 actually required inheritance, which is... less than ideal in my mind. Given my very nice wiggle word 'some', this is an achievable task assuming there is a week somewhere that I don't feel completely overwhelmed. I will endeavour to keep my eye out for a homework to sneak inheritance in again.


## Adjust the requirements of the homeworks

My grades this past term ended up a little bit higher than desired ("desired by whom?" excellent question that I will conveniently ignore). This is because I was erring on the side of cutting students slack given the current world situation. Even though the world will be the same spot next term, I do feel that I should increase the requirements on the homework slightly. I think I will have my own mental image be that the requirements I currently have will be the B level requirements and I'll add another thing for the last few points to reach an A. This thinking goes hand-in-hand with my reweighting of the rubrics to be 70% the core concepts and then the last 30% the extra things. 

This improvement has the benefit lacking in others that if I run out of time in a given week, I can leave that week's homework as is and no one will be the wiser! If I was doing full test suites, this improvement would conflict with them (do I do the test suite first and then adjust requirements and adjust the test suite??), but if I stick with partial test suites, the added requirement wouldn't need to be covered anyway.

## Make more videos instead of readings

This was another main request from the previous term's students. I had some videos at first before hitting the time wall and needing to cut somewhere and videos got cut. I also realized that videos about code aren't super helpful since students can't easily refer back to the video during class, as opposed to readings which are easy to refer back to. If I make videos, I will only make them for topics where it is generally a conceptual topic and there isn't syntax that students will need to refer back to. I definitely will not make any promise about a video for every class period and I am going to spend more time at the beginning of the term explaining this exact reasoning to my students. There are a few places though that I would love to explain the concept to students and then have them write the code instead of giving them a reading that has all the code already.

## Make reference sheets to go along with videos

Every term I encourage students to make their own cheat sheets/reference sheets from the readings and I don't think I've ever seen it really happen. Maybe once. Since I like doing coding labs where students solve a problem during class time, if I do videos that do have code, I might make a reference sheet that they can use during the associated lab. I will state clearly on the sheet that it isn't a substitute for watching the video and it will have basically no explanation, so that it only makes sense if you fully understood the video.

This one is a pretty low priority since I probably just won't make videos that involve code because I use the [OpenDSA textbook](https://opendsa-server.cs.vt.edu/) and it is pretty solid for most things.

# Conclusion

I think that I basically just decided to do all these things, which isn't a good plan. I'm going to attempt to prioritize things now.

1. Piazza to Moodle - because I basically have to and it's just set up before the term
2. Beginning of class polls - this is minimal extra work and I hope will lead to much improved question/discussion time
3. Reweight rubrics of the homeworks - I really want to emphasize the core concepts of the course and have the grading of the homework reflect that emphasis and this shouldn't be too much work
4. Develop polished solutions for the labs - While I'm skeptical if any student will actually look at these, it would be a good thing to do to help me prepare for class anyway
5. Develop partial test suites for the homework - This is a fairly big ask that will help and hurt learning, though I think it will help the students who a struggling more, which is generally my philosophy
6. Increase the requirements of the homeworks - While I do think I need to do this eventually, it is a fairly high cognitive load (since I want them to be meaningful additional requirements) and seems anti-thetical to best practices in the current world situation
7. Change some of the homeworks to require inheritance - This is really 6.5 since it would go along with 6, though it would be a core concept and therefore in the 70% points section
8. Make more videos instead of readings - The OpenDSA textbook is pretty darn great, so I just don't think most of the videos I could make would be helpful. I will record the beginning of class discussions, so I'm half doing this already
9. Make reference sheets to go along with videos - If I some day have so much time that I decide to make videos about code, I will do this, but that is not this term
10. Mastery grading scheme - a lot of the previous things will need to happen first

For the record, I'm super unsure and conflicted about the ordering of 4-7 and probably will end up doing some later priority items on a wild hair (hare?). I don't even know where to draw the line of how many of these things is reasonable to try. If you actually read this sentence and have an opinion, feel free to reach out and let me know!