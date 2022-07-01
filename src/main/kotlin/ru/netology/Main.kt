package ru.netology

internal class main {


}
data class Post (val id:Long,val authorId:Long,val authorName:String,val content: String,val created:Long,val likes:Int =0) {
    object WallService{
        private var posts = emptyArray<Post>()

        fun add(post: Post): Post {
            posts += post
            return posts.last()
        }

        fun likeById(id:Long){
            for ((index, post) in posts.withIndex()){
                if (post.id == id){
                    posts[index] = post.copy(likes = post.likes + 1)
                }
            }
        }

    }

}



fun main1(){
    val original = Post(
        id = 1,
        authorId = 1,
        authorName = "Имя",
        content = "Контент",
        created = 12322,
        likes = 22
    )

    val service = Post.WallService
    service.add(original)
}
