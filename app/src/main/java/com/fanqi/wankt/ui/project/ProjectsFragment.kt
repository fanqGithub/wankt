package com.fanqi.wankt.ui.project

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fanqi.wankt.R
import com.fanqi.wankt.common.bean.ProjectCategory
import com.fanqi.wankt.common.bean.ProjectItem
import com.fanqi.wankt.constant.Constant
import com.fanqi.wankt.ui.ArticleContentActivity
import kotlinx.android.synthetic.main.fragment_dashboard.view.*

class ProjectsFragment : Fragment() {

    private lateinit var dashboardViewModel: ProjectsViewModel
    private lateinit var categoryRecyclerView: RecyclerView
    private lateinit var projetRecyclerView: RecyclerView

    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var projectItemAdapter: ProjectItemAdapter
    private var categoryList = arrayListOf<ProjectCategory>()
    private var projectItemList = arrayListOf<ProjectItem>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
            ViewModelProviders.of(this).get(ProjectsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)
//        val textView: TextView = root.findViewById(R.id.text_dashboard)
//        dashboardViewModel.text.observe(this, Observer {
//            textView.text = it
//        })
        categoryRecyclerView = root.categoryList
        projetRecyclerView = root.projectList
        categoryAdapter = CategoryAdapter(categoryList)
        categoryAdapter.setCategoryCallBack(categoryAdapterCallBack)
        categoryRecyclerView.adapter = categoryAdapter

        projectItemAdapter = ProjectItemAdapter(projectItemList)
        projectItemAdapter.setItemCallBack(itemCallBack)
        projetRecyclerView.adapter = projectItemAdapter

        init()

        return root
    }

    fun init() {
        setStatusColor(resources.getColor(R.color.colorAccent))

        categoryList.clear()
        dashboardViewModel.initCategoryDatas()
        dashboardViewModel.categoryDatas.observe(this, Observer {
            categoryList.addAll(it)
            categoryAdapter.notifyDataSetChanged()
            //page
            var firstCategory = it[0]
            dashboardViewModel.initPage(firstCategory.id)
        })

        dashboardViewModel.projectDatas.observe(this, Observer {
            projectItemList.addAll(it)
            projectItemAdapter.notifyDataSetChanged()
        })

    }

    var categoryAdapterCallBack = object : CategoryAdapter.CategoryAdapterCallBack {

        override fun onSelected(position: Int, category: ProjectCategory) {
            //
            projectItemList.clear()
            dashboardViewModel.initPage(category.id)
        }
    }

    var itemCallBack = object : ProjectItemAdapter.ItemCallBack {
        override fun onItemClick(position: Int, projectItem: ProjectItem) {
            Intent(activity, ArticleContentActivity::class.java).run {
                putExtra(Constant.CONTENT_URL_KEY, projectItem.link)
                startActivity(this)
            }
        }

    }

    fun setStatusColor(color: Int) {
        val window = activity?.getWindow()
        window!!.statusBarColor = color
    }
}