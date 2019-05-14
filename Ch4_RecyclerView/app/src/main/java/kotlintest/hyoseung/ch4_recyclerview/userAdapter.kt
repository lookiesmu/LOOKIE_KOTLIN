package kotlintest.hyoseung.ch4_recyclerview

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class userAdapter(val context: Context, val userlist: ArrayList<user>) : RecyclerView.Adapter<userAdapter.Holder>(){
    override fun onBindViewHolder(p0: Holder, p1: Int) {
        p0.bind(userlist[p1],context)
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): Holder{
        val view = LayoutInflater.from(context).inflate(R.layout.view_user,p0,false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return userlist.size
    }

    inner class Holder(itemView : View) : RecyclerView.ViewHolder(itemView){
            val userName = itemView.findViewById<TextView>(R.id.view_user_name)
            val userAge = itemView.findViewById<TextView>(R.id.view_user_age)
            val userMajor = itemView.findViewById<TextView>(R.id.view_user_major)
            fun bind(user: user, context: Context){
                userName.text = user.name
                userAge.text = user.age.toString()
                userMajor.text = user.major
            }
    }
    fun add(user:user?){
        if(user == null)
            return
        userlist.add(0,user)
    }
}